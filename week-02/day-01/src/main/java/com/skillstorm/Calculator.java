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
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	// potential problems = divide by zero, int division
	public int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	public int getRandom(int num1, int num2) {
		
		// new Random() returns a random decimal between 0 and 1
		// .nextInt() returns a random integer between 0 and the number in the parentheses
		// we have to get a little creative to get useful random numbers
		// error intentional...will fix in testing!!
		return new Random().nextInt((num2 + 1) - num1) + num1 + 1;
		
	}


}