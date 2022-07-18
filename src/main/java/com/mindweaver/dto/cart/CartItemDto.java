package com.mindweaver.dto.cart;

import java.util.Objects;

import com.mindweaver.model.Cart;
import com.mindweaver.model.Product;

public class CartItemDto {

	private Long id;
	private Long quantity;
	private Product product;
	
	public CartItemDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItemDto(Long id, Long quantity, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItemDto [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemDto other = (CartItemDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(product, other.product)
				&& Objects.equals(quantity, other.quantity);
	}

	public CartItemDto(Cart cart) {
		this.id = cart.getId();
		this.quantity = cart.getQuantity();
		this.setProduct(cart.getProduct());
		
	}
	
	
	
	
	
}
