package com.mindweaver.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class ProductDto {  
	
	private Long id;
	private @NotNull String name;
	private @NotNull String imageUrl;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull Long categoryId;
	
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProductDto(@NotNull String name, @NotNull String imageUrl, @NotNull double price,
			@NotNull String description, @NotNull Long categoryId) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}


	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", imageUrl=" + imageUrl + ", price=" + price + ", description="
				+ description + ", categoryId=" + categoryId + "]";
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(categoryId, description, imageUrl, name, price);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(description, other.description)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
	
	
}
