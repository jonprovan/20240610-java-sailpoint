package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.ProductResponse;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	List<ProductResponse> products = Arrays.asList(
				new ProductResponse("chair"),
				new ProductResponse("sofa"),
				new ProductResponse("soap")
			);
	
	// /products
	@GetMapping
	public List<ProductResponse> getAllProducts() {
		return products;
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