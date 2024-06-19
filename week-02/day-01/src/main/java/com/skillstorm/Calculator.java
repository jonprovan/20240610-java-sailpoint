package com.skillstorm;

import java.util.Random;

// this is a class that we're going to be testing
public class Calculator {
	
	private String name;
	
	public Calculator() {
		super();
		this.name = "Default";
	}
	
	public Calculator(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// potential problem = overflow
	public long add(int num1, int num2) {
		return (long)num1 + (long)num2;
	}
	
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	// potential problems = divide by zero, int division
	public double divide(double num1, double num2) throws Exception {
		
		if(num1 == 1) {
			this.throwException(num1);
		}
		
		if(num2 == 0) {
			throw new IllegalArgumentException("Second parameter cannot be 0!");
		} else {
			return (double)num1 / (double)num2;
		}
		
	}
	
	// this method gets a random integer between the two params (inclusive of both)
	public int getRandom(int num1, int num2) {
		
		// new Random() returns a random decimal between 0 and 1
		// .nextInt() returns a random integer between 0 and the number in the parentheses
		// we have to get a little creative to get useful random numbers
		// error intentional...will fix in testing!!
		return new Random().nextInt((num2 + 1) - num1) + num1;
		
	}
	
	public void throwException(double num) throws Exception {
		if (num == 1) {
			throw new Exception();
		}
	}


}
