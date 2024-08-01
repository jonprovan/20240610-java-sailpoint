package com.skillstorm.services;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skillstorm.api.RecommendationsClient;
import com.skillstorm.dtos.ProductRequest;
import com.skillstorm.dtos.ProductResponse;

@Service
public class ProductsService {
	
	private final RecommendationsClient recommendationsClient;
	private final RabbitTemplate rabbitTemplate;
	
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Value("${topic.name}")
	private String topic;
	
	int id = 1;
	
	public ProductsService(RecommendationsClient recommendationsClient, RabbitTemplate rabbitTemplate) {
		this.recommendationsClient = recommendationsClient;
		this.rabbitTemplate = rabbitTemplate;
	}

	public List<ProductResponse> findRecommendedProducts() {
		// we will call the other microservice
		// this will fire off an HTTP request to the recommendations service
		// it uses eureka + ribbon to find the service
		return recommendationsClient.recommendProducts();
	}

	public void createProduct(ProductRequest product) {
		// create a "unique" id
		int productId = id++; // assign an id, then increment
		
		// save it to the db
		
		ProductResponse message = new ProductResponse(productId, product.name(), product.description());
		// send a message to the exchange that the product was created
		rabbitTemplate.convertAndSend(exchangeName, topic, message);
	}
}
