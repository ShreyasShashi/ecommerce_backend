package com.mindweaver.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long category_id;
	
	@Column(name = "category_name")
	private @NotBlank String categoryName;
	
	private @NotBlank String description;
	
	@Column(name = "image_url")
	private @NotBlank String imageUrl;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return category_id;
	}

	public void setId(Long id) {
		this.category_id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName, description, category_id, imageUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(description, other.description)
				&& Objects.equals(category_id, other.category_id) && Objects.equals(imageUrl, other.imageUrl);
	}

	@Override
	public String toString() {
		return "Category [id=" + category_id + ", categoryName=" + categoryName + ", description=" + description + ", imageUrl="
				+ imageUrl + "]";
	}

	public Category(Long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl) {
		super();
		this.category_id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	
}
