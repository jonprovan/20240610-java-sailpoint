package com.skillstorm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.api.RecommendationsClient;
import com.skillstorm.dtos.ProductResponse;

@Service
public class ProductsService {
	
	private final RecommendationsClient recommendationsClient;
	
	public ProductsService(RecommendationsClient recommendationsClient) {
		this.recommendationsClient = recommendationsClient;
	}

	public List<ProductResponse> findRecommendedProducts() {
		// we will call the other microservice
		// this will fire off an HTTP request to the recommendations service
		// it uses eureka + ribbon to find the service
		return recommendationsClient.recommendProducts();
	}
}
