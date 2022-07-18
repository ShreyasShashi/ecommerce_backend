package com.mindweaver.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindweaver.dto.ResponseDto;
import com.mindweaver.dto.user.SignInDto;
import com.mindweaver.dto.user.SignInResponseDto;
import com.mindweaver.dto.user.SignUpDto;
import com.mindweaver.exception.AuthenticationFailException;
import com.mindweaver.exception.CustomException;
import com.mindweaver.model.AuthenticationToken;
import com.mindweaver.model.User;
import com.mindweaver.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
 	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Transactional
	public ResponseDto signUp(SignUpDto signupDto) {
		
		// check if user is already present 
		
		if(Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))) {
			
			// we have an user 
			
			throw new CustomException("user already present");
		}
		
		// hash the password 
		String encryptedPassword = signupDto.getPassword();
		
		try {
			encryptedPassword = hashpassword(signupDto.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// save the user
		
		User user = new User(signupDto.getFirstName(), 
				signupDto.getLastName(), signupDto.getEmail(), encryptedPassword);
		
		 userRepo.save(user);
		
		
		
		// create the token  
		final AuthenticationToken authenticationToken = new AuthenticationToken(user);
		authenticationService.saveConfirmationToken(authenticationToken);
		 
		 // return the response so created a object 
		ResponseDto responseDto = new ResponseDto("success", "user created successfully");
		return responseDto;
	}

	private String hashpassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter
				.printHexBinary(digest).toUpperCase();
		return hash;
	}

	public SignInResponseDto signIn(SignInDto signInDto) {
		// find the user by email
		
		User user = userRepo.findByEmail(signInDto.getEmail());
		if(Objects.isNull(user)) {
			throw new AuthenticationFailException("Please enter a valid user Email Id");
		}
		
		// hash the password 
		// compare the password in DB
		//if password match
		
		try {
			if(!user.getPassword().equals(hashpassword(signInDto.getPassword())))
			{
				throw new AuthenticationFailException("please enter a valid password");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//retrieve the token
		AuthenticationToken token = authenticationService.getToken(user);
		
		if(Objects.isNull(token)) {
			throw new CustomException("token is not present");
		}
		
		// return response 
		
		return new SignInResponseDto("success", token.getToken());
	} 

	
}
