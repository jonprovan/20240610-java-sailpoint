package com.skillstorm.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.ProductResponse;

@Service
public class ProductRecommendationService {

	// method that handles the message being published to my queue
	@RabbitListener(queues = { "${queue.name}" })
	public void receiveCreatedProductDetails(@Payload ProductResponse product) {
		// do something interesting
		System.out.println(product);
	}
}
