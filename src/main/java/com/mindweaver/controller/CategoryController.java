package com.mindweaver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.common.ApiResponse;
import com.mindweaver.model.Category;
import com.mindweaver.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<>(new ApiResponse(true, "created a new category"), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public List<Category> listCategory() {
		return categoryService.listCategory();
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		if(!categoryService.findById(id)) {
			return new ResponseEntity<>(new ApiResponse(false, "category doesnt exist"), HttpStatus.NOT_FOUND);
		}
		categoryService.editCategory(id, category);
		return new ResponseEntity<>(new ApiResponse(true, "category has been updated"), HttpStatus.ACCEPTED);
		
	}

}
