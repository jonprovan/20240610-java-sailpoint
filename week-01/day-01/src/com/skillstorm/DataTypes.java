package com.skillstorm;

public class DataTypes {
	
	public static void main(String[] args) {
		
		/**
		 * DATA TYPES IN JAVA
		 * 
		 * whenever we need to store a value, we need to create a variable to hold it
		 * this allocates memory to the variable, according to what we want to put in it
		 * 
		 * PRIMITIVE DATA TYPES (one exception)
		 * 
		 * Numerical Data Types
		 * 
		 * Whole Number Types
		 * byte = 8 bits
		 * short = 16 bits
		 * int = 32 bits
		 * long = 64 bits
		 * 
		 * Decimal Number Types
		 * float = 32 bits
		 * double = 64 bits
		 * 
		 * True/False Type
		 * boolean = 1 bit, either true or false only
		 * 
		 * Alphanumeric Types
		 * char = a single character -- single quotes for char, 'a'
		 * String = any number of character -- NOT a primitive, actually an Object, double quotes for Strings, "a"
		 */
		
		System.out.println("Byte = " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
		System.out.println("Short = " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
		System.out.println("Int = " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
		System.out.println("Long = " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

		System.out.println("Float = " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
		System.out.println("Double = " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
		
		// char can be incremented
		char myChar = 'a';
		myChar++;
		System.out.println(myChar);
		
		// values wrap around, so you have be careful about value management
		int myInt = Integer.MAX_VALUE;
		System.out.println(myInt);
		myInt++;
		System.out.println(myInt);
		
		// wrapper classes create Objects around primitives
		// all named the same as the primitive except int -> Integer and char -> Character
		Integer myInteger = new Integer(4);
		myInteger = 7;
		System.out.println(myInteger);
		
		// storing data types in other data types
		long x = Long.MAX_VALUE;
		// can't do because long doesn't fit into int
		// int y = x;
		
		// can do this, because it fits
		int z = Integer.MAX_VALUE;
		long a = z;
		
		// sometimes have to cast numbers to store them
		// (type) casts the following value as whatever type is in the parentheses
		addAndPrint((byte)45);
		
	}
	
	public static void addAndPrint(byte by) {
		System.out.println(by);
	}

}
