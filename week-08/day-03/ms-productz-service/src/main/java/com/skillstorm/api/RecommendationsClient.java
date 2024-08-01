package com.skillstorm.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skillstorm.dtos.ProductResponse;

@FeignClient(name = "ms-recommendations-service")
public interface RecommendationsClient {

	@RequestMapping(method = RequestMethod.GET, value="/products/recommendations")
	public List<ProductResponse> recommendProducts();
}
