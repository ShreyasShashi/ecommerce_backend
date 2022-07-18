package com.mindweaver.dto.cart;

import java.util.Objects;

import lombok.NonNull;

public class AddToCartDto {

	private Long id;
	private @NonNull Long productId;
	private @ NonNull Long quantity;
	
	public AddToCartDto() {
		// TODO Auto-generated constructor stub
	}

	public AddToCartDto(Long id, @NonNull Long productId, @NonNull Long quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "AddToCartDto [id=" + id + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddToCartDto other = (AddToCartDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(productId, other.productId)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
	
}
