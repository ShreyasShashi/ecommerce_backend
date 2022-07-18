package com.mindweaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.dto.ResponseDto;
import com.mindweaver.dto.user.SignInDto;
import com.mindweaver.dto.user.SignInResponseDto;
import com.mindweaver.dto.user.SignUpDto;
import com.mindweaver.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// signUp API
	
	@PostMapping("/signup")
	public ResponseDto signup(@RequestBody SignUpDto signupDto) {
		
		return userService.signUp(signupDto);
	}
	
	// signIn API
	@PostMapping("/signin")
	public SignInResponseDto singIn(@RequestBody SignInDto signInDto) {
		return userService.signIn(signInDto);
	}
}
