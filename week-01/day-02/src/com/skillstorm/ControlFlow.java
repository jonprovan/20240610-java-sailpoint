package com.skillstorm;

public class ControlFlow {

	public static void main(String[] args) {
		
		/**
		 * Control Flow in Java
		 * 
		 * Generally, this consists of branching code that may or may not execute
		 * as well as loops
		 * 
		 * For branching:
		 * if
		 * if-else
		 * if-else if
		 * if-else if-else
		 * switch
		 * 
		 * For loops:
		 * for
		 * foreach/enhanced for
		 * while
		 * do-while
		 * 
		 */
		
		// if
		// if executes its block if a condition is true
		
		if (5 < 10) {
			System.out.println("5 is less than 10");
		}
		
		boolean myBoolean = false;
		
		if (myBoolean) {
			System.out.println("myBoolean is true");
		}
		
		// if-else
		// if the condition is true, do what's in the if block; otherwise, do what's in the else block
		if (!myBoolean) {
			System.out.println("If was true");
		} else {
			System.out.println("Else was false");
		}
		
		
		// else-if
		// checks a second (or nth) condition
		// can have as many else-ifs as you like, but if you have an else, it has to be last
		int myInt = 3;
		
		if (myInt > 10) {
			System.out.println("Greater than 10");
		} else if (myInt > 4) {
			System.out.println("Greater than 4");
		} else if (myInt == 3) {
			System.out.println("Equals 3");
		} else {
			System.out.println("None of the above");
		}
		
		
		// switch
		// checks against a non-boolean type
		// and takes action based on its contents from several options
		
		String str = "D";
		
		// checked value CANNOT be a boolean
		switch(str) {
		
			// break statement after each block to make sure we don't cascade through
			case "A":
				System.out.println("str == A");
				break;
			case "B":
				System.out.println("str == B");
				break;
			case "C":
				System.out.println("str == C");
				break;
			// default case like a catch-all, if none of the other cases match
			default:
				System.out.println("None of these apply");
				break;
		}
		
		
		// LOOPS
		
		// for
		
		
		// enhanced for
		
		
		// while
		// runs as long as a condition is true
		// checks the condition FIRST
		// may not ever run at all, if the condition starts false
		boolean condition = false;
		
		while (condition) {
			System.out.println("Running...");
		}
		
		int counter = 0;
		
		while (counter < 5) {
			System.out.println("Loop Index: " + counter++);
		}
		
		
		// do-while
		// does the code once, then checks the condition for the first time
		
		int otherCounter = 6;
		
		do {
			System.out.println("OC Loop Index: " + otherCounter++);
		} while (otherCounter < 5);
		
		
		
		
		
		

	}

}
