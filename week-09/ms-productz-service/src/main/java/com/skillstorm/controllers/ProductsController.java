package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.ProductRequest;
import com.skillstorm.dtos.ProductResponse;
import com.skillstorm.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	private final ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	// /products
	@GetMapping
	public List<ProductResponse> getAllProducts() {
		// I want to call the recommendations service to get this data
//		return products;
		return productsService.findRecommendedProducts();
	}
	
	@PostMapping
	public void createProduct(@RequestBody ProductRequest product) {
		productsService.createProduct(product);
	}

}


/*
 * USERS
 * - username
 * - password
 * - accountId
 * - profilePicture
 * 
 * UserRequest
 * - username
 * - password
 * - profilePicture
 * 
 * UserResponse (Data Transfer Object)
 * - username
 * - profilePicture 
*/