package com.mindweaver.dto.cart;

import java.util.List;
import java.util.Objects;

public class CartDto {

	List<CartItemDto> cartItems;
	private double totalCost;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "CartDto [cartItems=" + cartItems + ", totalCost=" + totalCost + "]";
	}

	public CartDto(List<CartItemDto> cartItems, double totalCost) {
		super();
		this.cartItems = cartItems;
		this.totalCost = totalCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartItems, totalCost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDto other = (CartDto) obj;
		return Objects.equals(cartItems, other.cartItems)
				&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost);
	}
	
	
	
}
