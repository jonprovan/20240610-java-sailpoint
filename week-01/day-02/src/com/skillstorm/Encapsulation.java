package com.skillstorm;

public class Encapsulation {

	public static void main(String[] args) throws IllegalAccessException {
		
		EncapsulatedAnimal animal = new EncapsulatedAnimal("Douglas", "Deer", 7.5);
		
		// can only do this if my variables are accessible
//		System.out.println(animal.name);
		
		// using our getter
		System.out.println(animal.getName());
		
		// inside a method, variables do NOT get default values and must be initialized in order to be accessed without an error
		String name;
		name = "Mel";
		
		System.out.println(name);
		
		// animal.name = "Delilah";  can't do this, because it's private
		animal.setName("Delilah");
		System.out.println(animal.getName());
		
		animal.setSpecies("      Jaguar       ");
		
		System.out.println(animal.getSpecies());

	}

}

class EncapsulatedAnimal {
	
	// access modifiers in Java
	
	/**
	 * public - any class anywhere in the program
	 * 
	 * protected - any class inside the package AND subclasses, even if they're in a different package
	 * 
	 * default - any class inside the package
	 * 
	 * private - only the class itself
	 * 
	 * FULL ENCAPSULATION
	 * private variables
	 * public getters/setters for those variables
	 * public methods mostly, but it depends
	 */
	
	// these are instance variables, i.e., ones who belong to a specific instance
	// if I don't give them values in my constructor or elsewhere, they take on default values
	// any Object (including String) becomes null
	// any numerical value becomes 0
	
	private String name;
	private String species;
	private double age;
	
	// if I don't create a constructor, Java makes one for us = default constructor
	
	// a no-args constructor
	public EncapsulatedAnimal() {}
	
	// if I just had this constructor and not the written-out no-args one above
	// I would NOT have access to a no-args default constructor
	public EncapsulatedAnimal(String name, String species, double age) throws IllegalAccessException {
		if (name == null) {
			throw new IllegalArgumentException("Cannot have a null name!");
		}
		
		this.name = name;
		this.species = species;
		this.age = age;
	}
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public double getAge() {
		return this.age;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpecies(String species) {
		if (species == null) {
			this.species = "Null Species";
		} else {
			this.species = species.trim();
		}
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	
	
}












