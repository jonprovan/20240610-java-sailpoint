package com.skillstorm;

// these imports are for things we'll need while testing
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// this class contains all the tests for our Calculator class
public class CalculatorTest {
	
	// TEST-DRIVEN DEVELOPMENT
	
	/*
	 * Instead of writing our code and then writing tests
	 * We develop all the tests first, THEN write the code to pass the tests
	 * 
	 * Takes more time at the top before getting anything functional actually built
	 * But, it can actually save you some time, because you know in advance exactly what your code is supposed to do/return
	 * 
	 * Testing "edge cases" is super-important -- behavior/inputs at the fringe of what's allowable
	 * - e.g., if our method should function properly with numbers 0-100, what happens with -1 and 101, for instance?
	 * 
	 * Advisable in general to break up tests into individual edge cases or scenarios
	 * 
	 * For a test, the baseline is: assert that something is true
	 * - if it is, we pass; if it's not, we fail
	 * 
	 * 
	 * Annotations:
	 * 
	 * @BeforeClass
	 * - occurs at the very BEGINNING of this test case and only happens once
	 * - the method here MUST be static and cannot create or use instance variables of this class
	 * - use case: set up resources that may be used in all the tests in this class
	 * 
	 * @Before
	 * - occurs before EACH test, however many you have, and is non-static
	 * - can set up something you need for each test but don't need in between or overall, etc.
	 * 
	 * @Test
	 * 
	 * @After
	 * - occurs AFTER each test, however many you have, and is also non-static
	 * - can break something down, print results, whatever
	 * 
	 * @AfterClass
	 * - occurs at the very END of this test case and only happens once
	 * - method must also be static, etc.
	 * - use case: tear down resources used in all the tests
	 */
	
	public static Calculator calc;
	
	// instantiates a static instance of Calculator we can use throughout
	@BeforeClass
	public static void setup() {
		System.out.println("Running - BeforeClass");
		calc = new Calculator();
	}
	
	@Before
	public void beforeEach() {
		System.out.println("Running - Before");
	}

	@Test
	public void basicAddition() {
		System.out.println("Basic Addition Test");
		
		// can do the math here to assemble a correct answer to assert
		int assertedAnswer = 4 + 7;
		
		long sum = calc.add(4, 7);
		
		assertEquals(assertedAnswer, sum);
	}
	
	@Test
	public void additionOverflow() {
		System.out.println("Addition Overflow Test");
		
		long largeNum = 2000000000L + (long)2000000000;
		
		long sum = calc.add(2000000000, 2000000000);
		
		assertEquals(largeNum, sum);
	}
	
	@Test
	public void additionEdgeCase() {
		System.out.println("Addition Edge Case Test");
		
		long maxValue = (long)Integer.MAX_VALUE * (long)2;
		
		assertEquals(maxValue, calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void additionEdgeCases() {
		System.out.println("Addition Edge Cases Test");
		
		long maxValue = (long)Integer.MAX_VALUE * (long)2;
		long minValue = (long)Integer.MIN_VALUE * (long)2;
		
		assertTrue(
				maxValue == calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE)
			&&  minValue == calc.add(Integer.MIN_VALUE, Integer.MIN_VALUE)
				);
	}
	
	@After
	public void afterEach() {
		System.out.println("Running - After");
	}
	
	// destroys my static instance to save memory if I'm running a bajillion tests
	@AfterClass
	public static void teardown() {
		System.out.println("Running - AfterClass");
		calc = null;
	}

}
