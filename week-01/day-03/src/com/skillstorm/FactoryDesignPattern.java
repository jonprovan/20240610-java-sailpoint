package com.skillstorm;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		
		/**
		 * FACTORY DESIGN PATTERN
		 * 
		 * - when you want to create one of a number of different objects
		 * - BUT, you don't want the user to directly instantiate one or choose which type to generate
		 * - we can create a "Factory" to generate different objects/results depending on input
		 */
		
		ShapeFactory sf = new ShapeFactory();
		
		Shape s = sf.makeShape(5);
		System.out.println("I am a " + s.getClass() + " and I have " + s.numberOfSides + " sides.");

	}

}

class ShapeFactory {
	
	public Shape makeShape(int numberOfSides) {
		
		switch(numberOfSides) {
		
			case 3:
				return new Triangle(3);
			case 4:
				return new Square(4);
			case 5:
				return new Pentagon(5);
			default:
				throw new IllegalArgumentException("Number of sides not applicable!");
		
		}
		
	}
	
}



abstract class Shape {
	
	int numberOfSides;
	
	public Shape(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	
}

class Triangle extends Shape {
	public Triangle(int numberOfSides) {
		super(numberOfSides);
	}
}

class Square extends Shape {
	public Square(int numberOfSides) {
		super(numberOfSides);
	}
}

class Pentagon extends Shape {
	public Pentagon(int numberOfSides) {
		super(numberOfSides);
	}
}





