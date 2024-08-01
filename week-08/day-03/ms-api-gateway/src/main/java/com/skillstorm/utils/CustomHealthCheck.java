package com.skillstorm.utils;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {
	
	private boolean isHealthy = true;

	@Override
	public Health health() {
		// business logic in here for determining if the app is healthy
		// existsProductsFromProductsMicroservice
		if (!isHealthy) {
			return Health.down().withDetail("circuit-breaker", "circuit breaker is open").build();
		}
		
		return Health.up().build();
	}

	public void setIsHealthy(boolean isHealthy) {
		this.isHealthy = isHealthy;
	}
	
}
