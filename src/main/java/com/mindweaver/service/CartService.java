package com.mindweaver.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindweaver.dto.cart.AddToCartDto;
import com.mindweaver.dto.cart.CartDto;
import com.mindweaver.dto.cart.CartItemDto;
import com.mindweaver.exception.CustomException;
import com.mindweaver.model.Cart;
import com.mindweaver.model.Product;
import com.mindweaver.model.User;
import com.mindweaver.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartRepository cartRepository;
	
	public void addToCart(AddToCartDto addToCartDto, User user) {
		
		//validate if the product id is valid
		Product product = productService.findById(addToCartDto.getProductId());
		
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(addToCartDto.getQuantity());
		cart.setCreatedDate(new Date());
		
		
		// then we save the cart 
		cartRepository.save(cart);
		
	}

	public CartDto listCartItems(User user) {
		final List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
		
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalCost = 0;
		for(Cart cart: cartList) {
			CartItemDto cartItemDto = new CartItemDto(cart);
			totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
			cartItems.add(cartItemDto);
		}
		
		CartDto cartDto = new CartDto();
		cartDto.setTotalCost(totalCost);
		cartDto.setCartItems(cartItems);
		return cartDto;
	}

	public void deleteCart(Long cartItemId, User user) {
		
		//the item id should belong to user
		Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
		if(optionalCart.isEmpty()) {
			throw new CustomException("cart Item id is invalid : "+cartItemId);
		}
		Cart cart = optionalCart.get();
		if(cart.getUser() != user) {
			throw new CustomException("cart item does not belong to user: "+cartItemId);
		}
		
		cartRepository.delete(cart);
	}

}
