package com.mindweaver.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindweaver.exception.AuthenticationFailException;
import com.mindweaver.model.AuthenticationToken;
import com.mindweaver.model.User;
import com.mindweaver.repository.TokenRepo;

@Service
public class AuthenticationService {

	@Autowired
	private TokenRepo tokenRepo; 
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		tokenRepo.save(authenticationToken);
		
	}

	public AuthenticationToken getToken(User user) {
		return tokenRepo.findByUser(user);
	}

	public User getUser(String token) {
	
		final AuthenticationToken authenticationToken = tokenRepo.findByToken(token);
			
		// verify if authentication token is null 
		
		if(Objects.isNull(authenticationToken)) {
			return null;
		}
		
		// AuthenticationToken is not null                                                                                                                                                                                                                          not null 
		
		return authenticationToken.getUser();
	}
	
	public void authenticate(String token) {
		// null check validation 
		
		if(Objects.isNull(token)) {
			//throw an exception
			throw new AuthenticationFailException("Requested token does not exist");
		}
		
		if(Objects.isNull(getUser(token))) {	
			throw new AuthenticationFailException("token not valid");
		}
	}
}
