package com.mindweaver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.common.ApiResponse;
import com.mindweaver.dto.ProductDto;
import com.mindweaver.model.Product;
import com.mindweaver.model.User;
import com.mindweaver.model.WishList;
import com.mindweaver.service.AuthenticationService;
import com.mindweaver.service.WishListService;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private WishListService wishListService;
	
	
	//save product in wishList
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addTowishList(@RequestBody Product product,
													@RequestParam("token") String token){
		
		//authenticate the token 
		
		authenticationService.authenticate(token);
		
		// find the user

		User user = authenticationService.getUser(token);
		
		// save the item in the wishList
		
		WishList wishList = new WishList(user, product);
		
		wishListService.createWishList(wishList);
		
		ApiResponse apiResponse = new ApiResponse(true, "Added to wishlist");
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}
	
	// get all wishList item for a user 
	
	@GetMapping("/{token}")
	public ResponseEntity<List<ProductDto>> getAllWishList(@PathVariable("token") String token){
	
		//authenticate the token 
		
				authenticationService.authenticate(token);
				
				// find the user

				User user = authenticationService.getUser(token);
				
				List<ProductDto> productDtos= wishListService.getListWishListUser(user);
				return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}
	
	
}
