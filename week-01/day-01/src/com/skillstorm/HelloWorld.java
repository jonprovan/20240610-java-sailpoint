// this is a Java comment
/**
 * this is a Java mult-line comment
 * code in any comment will not execute
 */

// this is a package declaration
// this will become more important when we get to encapsulation
// the package declaration MUST come before the class declaration (if you have one)
package com.skillstorm;

// this is a class declaration
// public class name MUST match the name of the file
// naming convention = Pascal Case, i.e., capitalized first letter in each word, no spaces
public class HelloWorld {
	
	// this is my main method, the first thing Java will run when my program starts
	/**
	 * public = can be accessed from anywhere
	 * static = belongs to the class itself, not an instance, we DO NOT need an instance to run it
	 * void = this method returns nothing
	 * main = the name of the method
	 * () = arguments we're taking in
	 * String[] = a String array, args = the name we're assigning to that array
	 * 
	 */
	public static void main(String[] args) {
		
		// this prints whatever's in the parentheses to the console
		System.out.println("Hello, World!");
		
		// type "sysout" and click Ctrl-Space to fill out the print line
		System.out.println("Yay, I sysouted!");
		
	}

}
