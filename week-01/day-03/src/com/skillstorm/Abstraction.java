package com.skillstorm;

public class Abstraction {

	public static void main(String[] args) {
		
		// ABSTRACTION in Java
		/**
		 * hide the details of implementation from your user (a person or another piece of code)
		 * partially-build objects/classes/etc. for later implementation
		 * 
		 * abstract classes
		 * interfaces
		 * design patterns
		 * 
		 * Abstract Classes
		 * - you can only inherit from ONE abstract class
		 * - can have implemented methods
		 * - can have properties
		 * - can have constructors
		 * - can have unimplemented (abstract) methods that must be implemented in a child class
		 * - CANNOT be instantiated
		 */
		
		// can't do this, because Person is abstract
		// Person person = new Person();
		
		// I CAN do this, and and Employee IS-A Person
		Person employee = new Employee("Xena", 30);
		
		employee.sayName();
		employee.sayClass();
		
		Person gradStudent = new GradStudent();
		
		gradStudent.sayClass();

	}

}

abstract class Person {
	
	String name;
	int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayName() {
		System.out.println("My name is " + this.name + ".");
	}
	
	// this is an abstract method which must be implemented in a child class
	public abstract void sayClass();
	
}

class Employee extends Person {
	
	public Employee(String name, int age) {
		super(name, age);
	}
	
	// this is us implementing the abstract method, i.e., giving it a body
	@Override
	public void sayClass() {
		System.out.println(this.getClass());
	}
	
}

abstract class Student extends Person {
	
}

class GradStudent extends Student {

	@Override
	public void sayClass() {
		System.out.println(this.getClass());
	}
	
}

class HighSchoolStudent extends Student {

	@Override
	public void sayClass() {
		System.out.println(this.getClass());
	}
	
}











