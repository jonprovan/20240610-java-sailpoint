package com.skillstorm;

import java.io.IOException;

public class Exceptions {

	public static void main(String[] args) throws IOException {
		/**
		 * EXCEPTIONS IN JAVA
		 * 
		 * Problems that arise while code is running -- something goes wrong
		 * Could include instructions about how to fix it
		 * We can handle them to ensure that the code continues to run
		 * 
		 * An Exception is itself an Object
		 * If an Exception is not handled, the program will stop
		 * 
		 * Checked Exceptions
		 * - one which the compiler/IDE can anticipate
		 * - you cannot compile without handling these somehow
		 * 
		 * Unchecked Exceptions
		 * - one which the compiler/IDE cannot anticipate
		 * - you can still try to anticipate and handle them, but you'll have to do it on your own
		 * 
		 * Exceptions vs. Errors
		 * - generally speaking, an error is something you cannot anticipate and cannot rebound from
		 * 
		 * Three main ways to handle Exceptions:
		 * 1. Write good code to avoid Exceptions completely
		 * 2. try/catch -- try some code that might throw an Exception, catch the Exception and handle it
		 * 3. throws -- declare that a method throws an Exception and kinda "gloss over it" for now
		 * Honorable Mention -- let your users figure it out
		 * 
		 * Exceptions have a parent-child hierarchy; this matters during try/catch
		 * 
		 * 
		 */
		
		// this throws a runtime exception, unchecked
		// int x = 1/0;
		
		int a = 5;
		int b = 5;
		
		int[] nums = { 1, 2, 3, 4, 5 };
		
		// try/catch
		try {
			// the code we're going to attempt
			int quotient = a/b; // if the Exception gets thrown here, code stops at this point, rest of try block does not execute
			System.out.println(quotient);
			
			System.out.println(nums[4]);
			
			throw new Exception("Well, we tried...");
			
			// can have multiple catch blocks for different types of Exceptions
			// can't do this because Exception catches EVERYTHING; have to put it later on
//		} catch (Exception e) {
			
			// have to go most specific in the hierarchy to least specific
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Can't divide by zero!");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Last index in nums is: " + (nums.length - 1));
		} catch (Exception e) {
			e.printStackTrace();
			// the finally block (optional) will execute REGARDLESS of whether an Exception was thrown
			// put another way, it will always execute
		} finally {
			System.out.println("Reached the Finally block!");
		}
		
		// you can have a try/catch, a try/finally, or a try/catch/finally, but NOT a try by itself
		
		
		try {
			test();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		test();
		
		// throwing and not handling an Exception fully stops the program, so I never get here!
		System.out.println("Do I print?");

	}
	
	// try/finally useful for kicking the can down the road to another developer -- "Hey, you solve this!"
	// the throws declaration can also allow you to handle exceptions in a calling method
	// you can pass it up as far as you like, but you have to handle it somewhere
	public static void test() throws IOException {
		try {
			int x = 1/0;
			throw new IOException();
		} finally {
			System.out.println("Yay!");
		}
	}

}
