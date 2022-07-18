package com.mindweaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.common.ApiResponse;
import com.mindweaver.dto.cart.AddToCartDto;
import com.mindweaver.dto.cart.CartDto;
import com.mindweaver.model.User;
import com.mindweaver.service.AuthenticationService;
import com.mindweaver.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AuthenticationService authenticationService;

	//post cart api
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
			@RequestParam("token") String token){
		
		//authenticate the token 
		
		authenticationService.authenticate(token);
		
		// find the user

		User user = authenticationService.getUser(token);
		

		cartService.addToCart(addToCartDto, user);
		return new ResponseEntity<>(new ApiResponse(true, "Added to cart "), HttpStatus.CREATED);
				
	}
	
	//get all cart items for a user 
	
	@GetMapping("/")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
		
		//authenticate the token 

		authenticationService.authenticate(token);
		
		// find the user

		User user = authenticationService.getUser(token);
		
		// get cart items
		
		CartDto cartDto = cartService.listCartItems(user);
		return new ResponseEntity<>(cartDto, HttpStatus.OK);

	}
	
	//delete a cart item for a user 
	
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long itemId, 
															@RequestParam("token") String token){
																
		//authenticate the token 

		authenticationService.authenticate(token);
		
		// find the user

		User user = authenticationService.getUser(token);
		cartService.deleteCart(itemId, user);
		
		return new ResponseEntity<>(new ApiResponse(true, "Item has been Removed SuccessFully"), HttpStatus.OK);
		
	}
	
}
