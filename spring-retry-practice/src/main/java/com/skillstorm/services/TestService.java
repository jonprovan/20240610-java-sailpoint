package com.skillstorm.services;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Retryable(retryFor = { RuntimeException.class }, maxAttempts = 1, backoff = @Backoff(delay = 1000, multiplier = 2))
	public double getRandomNumber() {
		double num = generateRandomNumber();
		System.out.println("Random Number Created: " + num);
		if (num < 50) {
			throw new RuntimeException(num + "");
		}
		return num;
	}
	
	@Recover
	public double recoveryNumber(RuntimeException e) {
		return Double.parseDouble(e.getMessage());
	}
	
	// [0, 100]
	private double generateRandomNumber() {
		return Math.random() * 100;
	}
}
