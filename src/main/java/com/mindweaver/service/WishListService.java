package com.mindweaver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindweaver.dto.ProductDto;
import com.mindweaver.model.User;
import com.mindweaver.model.WishList;
import com.mindweaver.repository.WishListRepo;

@Service
public class WishListService {

	
	@Autowired
	private WishListRepo wishListRepo;
	 
	@Autowired
	ProductService productService;
	
	
	public void createWishList(WishList wishList) {
		
		wishListRepo.save(wishList); 
		
	}

	public List<ProductDto> getListWishListUser(User user) {
		final List<WishList> wishLists = wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
		List<ProductDto> productDtos = new ArrayList<>();
		for(WishList wishList: wishLists) {
			productDtos.add(productService.getAllProductDto(wishList.getProduct()));
		}
		return productDtos;
	}
	
	
	
}
