package com.mindweaver.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	private  String name;
	private  String imageUrl;
	private  double price;
	private  String description;
	
	//many to one relationship with category and products, mean each category may have multiple products 
	
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name ="category_id")
	 Category category;
	
	public Product() {
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", imageUrl=" + imageUrl + ", price=" + price
				+ ", description=" + description + ", category=" + category + "]";
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long product_id, @NotNull String name, @NotNull String imageUrl, @NotNull double price,
			@NotNull String description, Category category) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, imageUrl, name, price, product_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product_id, other.product_id);
	}
	
}
