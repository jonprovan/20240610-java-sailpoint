package com.skillstorm;

import java.util.LinkedList;
import java.util.List;

public class Polymorphism {

	public static void main(String[] args) {
		/**
		 * POLYMORPHISM in Java
		 * 
		 * "different types" "many forms"
		 * 
		 * - IS-A relationship
		 * - method overriding -- adding specific functionality to the same method in a child class
		 * 		- same method signature
		 * 		- runtime polymorphism
		 * - method overloading -- same method with different parameters (can also have a different return type)
		 * 		- MUST have different parameters, CAN have a different return type
		 * 		- compile-time polymorphism
		 * 
		 * General note about overriding -- static methods DO NOT override
		 */
		
		SteakTartare st = new SteakTartare();
		
		Entree e = st;
		MenuItem mi = e;
		
		// can't do this, because an Entree is not necessarily a SteakTartare
		// SteakTartare st2 = new Entree();
		
		// will often see more generic typing with collections
		List<String> myList = new LinkedList<>();
		
		SteakTartare mi2 = new SteakTartare();
		ChickenParm mi3 = new ChickenParm();
		NewYorkStrip mi4 = new NewYorkStrip();
		Drink d = new Drink();
		
		MenuItem[] menu = new MenuItem[4];
		
		menu[0] = mi2;
		menu[1] = mi3;
		menu[2] = mi4;
		menu[3] = d;
		
		// checking for NewYorkStrip items before running our specific method only available in that class
		for (MenuItem menuItem : menu) {
			if (menuItem.getClass() == NewYorkStrip.class) {
				((NewYorkStrip) menuItem).beTasty();
			}
			menuItem.consume();
		}
		
		// if I use a more general type, I won't have access to the methods not available in the general type
		// without doing something else
		MenuItem mi5 = new NewYorkStrip();
		
		// doesn't work because MenuItem doesn't have this method
		// mi5.beTasty();
		
		// casting as a type with the method so I can run it
		NewYorkStrip nys = (NewYorkStrip) mi5;
		nys.beTasty();
		
		// overloading
		System.out.println(add(5));
		System.out.println(Polymorphism.add(3, 4));
		System.out.println(Polymorphism.add(3, 12, 123));
		
		// I have access to overloaded methods, even across the inheritance structure
		Drink d2 = new Drink();
		d2.print(0, 0, 0);
		
	}
	
	public static int add(int num) {
		return num += num;
	}
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// different types for numbers still make for a different method overload
	public static int add(long num1, long num2) {
		return (int)(num1 + num2);
	}
	
	// return type can change, but not if you keep the same parameter sequence
	public static String add(int num1, int num2, int num3) {
		int add = num1 + num2 + num3;
		String str = "Result is: " + add;
		return str;
	}
	
	// order change is valid, even with the same number/type of parameters
	public static void order(String myStr, int myInt) {
		
	}
	
	public static void order(int myInt, String myStr) {
		
	}

}



class MenuItem {
	
	// note that this has the default access modifier
	void consume() {
		System.out.println("Consume MenuItem");
	}
	
	public void print(int i, int j) {
		
	}
	
}

class Drink extends MenuItem {
	
	// you can widen the access for an override method but NOT narrow it
	// default overridden with public is okay, but public overridden with default is not
	@Override
	public void consume() {
		System.out.println("Consume Drink");
	}
	
	public void print(int i, int j, int k) {
		super.consume();
	}
	
}

class Entree extends MenuItem {
	
	@Override
	public void consume() {
		System.out.println("Consume Entree");
	}
	
}

class SteakTartare extends Entree {
	
	@Override
	public void consume() {
		System.out.println("Consume SteakTartare");
	}
}

class ChickenParm extends Entree {
	
	@Override
	public void consume() {
		System.out.println("Consume ChickenParm");
	}
	
}

class NewYorkStrip extends Entree {
	
	@Override
	public void consume() {
		System.out.println("Consume NewYorkStrip");
	}
	
	public void beTasty() {
		System.out.println("I am now so tasty!");
	}
	
}
