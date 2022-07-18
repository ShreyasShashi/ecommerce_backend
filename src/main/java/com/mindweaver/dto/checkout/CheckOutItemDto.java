package com.mindweaver.dto.checkout;

import java.util.Objects;

public class CheckOutItemDto {

	private String productName;
	private Long quantity;
	private double price;
	private Long productId;
	private Long userId;
	
	public CheckOutItemDto() {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public CheckOutItemDto(String productName, Long quantity, double price, Long productId, Long userId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.productId = productId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CheckOutItemDto [productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ ", productId=" + productId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, productId, productName, quantity, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckOutItemDto other = (CheckOutItemDto) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(userId, other.userId);
	}
	
	
	
	
}
