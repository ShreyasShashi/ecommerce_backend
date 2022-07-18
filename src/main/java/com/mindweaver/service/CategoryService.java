package com.mindweaver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindweaver.model.Category;
import com.mindweaver.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public void createCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> listCategory() {
		return categoryRepo.findAll();
	}

	public void editCategory(Long id, Category updatecategory) {
		Category category = categoryRepo.getById(id);
		category.setCategoryName(updatecategory.getCategoryName());
		category.setDescription(updatecategory.getDescription());
		category.setImageUrl(updatecategory.getImageUrl());
		categoryRepo.save(category);
	}

	public boolean findById(Long id) {
		return categoryRepo.findById(id).isPresent();
		}
}
