package com.skillstorm;

public class Interfaces {

	public static void main(String[] args) {
		/**
		 * INTERFACES in Java
		 * 
		 * - cannot be instantiated
		 * - can have unimplemented (abstract) methods
		 * - cannot have implemented methods (one exception)
		 * - can have properties, but they are public, static and final by default
		 * - can implement more than one interface in a given class
		 * 
		 * Think of an interface as a contract -- a class which implements one has to do certain things (methods)
		 */
		
		// can't do this, because interfaceNumber is final
		// Testable.interfaceNumber = 6;
		
		WebApp app = new WebApp();
		Testable t = new WebApp();
		SoftwareProduct sp = new WebApp();
		
		t.test();
		sp.run();
		
		t.sayNumber();

	}

}

class ExpensiveItem {
	
}

interface Testable {
	// properties are automatically made public, static and final
	// this is essentially a class-level constant
	int interfaceNumber = 1;
	
	// abstract by default, and I cannot implement it here
	public void test();
	
	// the only way you can implement a method in an interface
	default public void sayNumber() {
		System.out.println("Interface Number is " + interfaceNumber);
	}
}

interface SoftwareProduct {
	
	int interfaceNumber = 2;
	
	public void run();
	public void test();
}

// you can extend and implement at the same time
// you can implement as many interfaces as you like
class WebApp extends ExpensiveItem implements Testable, SoftwareProduct {

	@Override
	public void run() {
		System.out.println("Here we GOOOOOO...");
	}

	@Override
	public void test() {
		System.out.println("Testing, testing, one, two, three...");	
	}
	
}










