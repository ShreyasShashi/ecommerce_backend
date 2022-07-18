package com.mindweaver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindweaver.dto.ProductDto;
import com.mindweaver.exception.ProductNotExistsException;
import com.mindweaver.model.Category;
import com.mindweaver.model.Product;
import com.mindweaver.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void createProduct(ProductDto productDto, Category category) {
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImageUrl());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCategory(category);
		productRepo.save(product);
	}

	public ProductDto getAllProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setDescription(product.getDescription());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setCategoryId(product.getCategory().getId());
		productDto.setId(product.getProduct_id());
		return productDto;
	}
	
	public List<ProductDto> getAllPRoducts() {
		List<Product> allProducts =productRepo.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for(Product product: allProducts) {
			productDtos.add(getAllProductDto(product));
		}
		return productDtos;
	}

	public void updateProduct(ProductDto productDto, Long productId) throws Exception {
		Optional<Product> optionalProduct = productRepo.findById(productId);
		if(!optionalProduct.isPresent()) {
			throw new Exception("product not present");
		}
		Product product = optionalProduct.get();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImageUrl());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		productRepo.save(product);
	}

	public Product findById(Long productId) {
		Optional<Product> optionalProduct =  productRepo.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotExistsException("product id is invalid :" +productId);
		}
		return optionalProduct.get();
		
	}
}
