package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.ProductResponse;

@RestController
public class ProductRecommendationController {
	
	List<ProductResponse> products = Arrays.asList(
			new ProductResponse(1, "chair", "it's a chair"),
			new ProductResponse(2, "sofa", "sofa sofa sofa"),
			new ProductResponse(3, "soap", "we found dove in a soapless place")
		);

	@GetMapping("/products/recommendations")
	public List<ProductResponse> recommendProducts() {
		products.sort((p1, p2) -> p1.name().compareTo(p2.name()));
		return products;
	}
	
}
