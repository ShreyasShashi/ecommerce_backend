package com.mindweaver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.common.ApiResponse;
import com.mindweaver.dto.ProductDto;
import com.mindweaver.model.Category;
import com.mindweaver.model.Product;
import com.mindweaver.repository.CategoryRepo;
import com.mindweaver.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> crateProduct(@RequestBody ProductDto productDto){
		
		// first check if category id is available
		
		Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			return new ResponseEntity<> (new ApiResponse(false, "caetgory does not exist..!!"), HttpStatus.BAD_REQUEST);
		}
		
		 // creating a product with with category id 
		
		productService.createProduct(productDto, optionalCategory.get());
		return new ResponseEntity<>(new ApiResponse(true, "product as been added successfully"), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProducts(){ 
		List<ProductDto> products = productService.getAllPRoducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) throws Exception{
		Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
		if(!optionalCategory.isPresent()) {
			return new ResponseEntity<> (new ApiResponse(false, "caetgory does not exist..!!"), HttpStatus.BAD_REQUEST);
		}
		productService.updateProduct(productDto, id);
		return new ResponseEntity<>(new ApiResponse(true, "product as been added successfully"), HttpStatus.CREATED);
	}
	
}    
