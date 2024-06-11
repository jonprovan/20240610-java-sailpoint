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
		// to loop code a specific number of times
		// takes in a variable, a condition, and an action to execute after each loop
		for (int i = 0; i < 5; i++) {
			System.out.println("Index = " + i);
		}
		
		String[] strings = { "a", "b", "c", "d", "e" };
		
		for (int i = 0; i < strings.length; i++) {
			System.out.println("Value at Index " + i + " = " + strings[i]);
		}
		
		
		// enhanced for
		// iterates through elements in a collection of some sort to do something with each
		// advantages = easier syntax, more readable
		// disadvantages = no direct access to the index, an extra variable
		
		int[] nums = { 2, 4, 6, 8, 10 };
		
		for (int num : nums) {
			num+=3;
		}
		
		// we haven't changed the original value, because num is just a local variable inside the loop body
		System.out.println(nums[0]);
		
		int counterX = 0;
		
		for (int num : nums) {
			
			// to change the original array, we need access to the index
			nums[counterX] = num * 2;
			counterX++;
		}
		
		// now we've changed the actual value in the original array
		System.out.println(nums[0]);
		
		
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
		
		
		// The Ternary Operator
		// a shorthand way of asking a boolean question
		// and taking an action or returning a result
		
		/**
		 * if (condition) {} else {}
		 * condition ? something : somethingelse
		 */
		boolean isIt = true;
		
		String myName = (isIt) ? "Jon" : "Marla";
		
		/**
		 * if (isIt) {
		 * 		return "Jon";
		 * } else {
		 * 		return "Marla";
		 * }
		 */
		
		System.out.println(myName);
		
		int questionNum = ("a" == "b") ? (4 < 6) ? 8 : 9 : 10;
		
		System.out.println(questionNum);
		
		// exporting this same question to a method to reuse the functionality
		System.out.println(ternary("a", "b"));
	}
	
	public static int ternary(String a, String b) {
		return (a == b) ? (4 < 6) ? 8 : 9 : 10;
	}
	
	
	
	

}
