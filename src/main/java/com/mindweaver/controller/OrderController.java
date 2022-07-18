package com.mindweaver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.dto.checkout.CheckOutItemDto;
import com.mindweaver.dto.checkout.StripeResponse;
import com.mindweaver.service.AuthenticationService;
import com.mindweaver.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private OrderService orderService;
	
	
	//stripe session checkout API 
	
	@PostMapping("/crate-checkout-session")
	public ResponseEntity<StripeResponse> checkOutList(@RequestBody List<CheckOutItemDto> CheckoutItemDtoList) 
			throws StripeException{
		
		Session session= orderService.createSession(CheckoutItemDtoList);
		StripeResponse stripeResponse = new StripeResponse(session.getId());
		return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
	}
}
