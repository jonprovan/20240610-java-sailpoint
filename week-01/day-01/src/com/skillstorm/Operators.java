package com.skillstorm;

public class Operators {

	public static void main(String[] args) {
		
		/**
		 * Operators in Java
		 * 
		 * Mathematical Operators
		 * + = adds or concatenates strings
		 * - = subtracts
		 * / = divides
		 * * = multiplies
		 * % = modulus/modulo -- divides the first number by the second and returns the remainder
		 * = assignment operator
		 * 
		 * PEMDAS applies
		 * int z = (1 + ((3 / 5) * 10)) + 1 - 6
		 * 
		 * We can increment variables as well (NOT values)
		 * Can't say int x = 1++
		 * 
		 * ++ = adds 1 to a variable value
		 * -- = subtracts 1
		 * 
		 * += - adds the value on the right to the variable value, so if myInt = 2 and I say myInt += 4, myInt now equals 6
		 * -= - same with subtraction
		 * /= - same with division
		 * *= - same with multiplication
		 * %= - same with modulus
		 * 
		 * 
		 * Boolean Operators
		 * 
		 * Comparison
		 * == - equality
		 * < - less than
		 * > - greater than
		 * <= - less than or equal
		 * >= - greater than or equal
		 * != - not equal
		 * 
		 * ! - reverses boolean state of whatever follows, so !true = false
		 * 
		 * these relate boolean values
		 * 
		 * || - or ... is either the statement on the left OR the statement on the right true?
		 * | - bitwise or
		 * && - and ... are both statements true?
		 * & - bitwise and
		 * !(x && y) - NAND or not-and
		 * !(x || y) - NOR or not-or
		 * ^ - XOR - exclusive or
		 * !^ - not XOR
		 * 
		 */
		
		System.out.println(4 + 7);
		
		int x = 6 * 5;
		
		System.out.println(x);
		
		System.out.println(9 % 4);
		
		System.out.println();
		
		// increment/decrement
		int y = 15;
		System.out.println(y);
		
		y++;
		System.out.println(y);
		
		// y++ - postfix
		// ++y - prefix
		
		System.out.println(++y);
		System.out.println(y++);
		System.out.println(y);
		
		// careful where you're incrementing!!
		int a = 5;
		int b = a++;
		System.out.println(a + b);
		
		// boolean operators
		
		System.out.println(4 > 10);
		System.out.println(10 % 2 != 1);
		// comparison operators return a boolean, so this doesn't compile
		// System.out.println(5 > 4 <= 2);
		
		System.out.println(true || false);
		System.out.println(true && false);
		
		Object obj = null;
		
		// this never checks the righthand side, because the left is true
		// if I did check it, I'd throw an Exception
		System.out.println(obj == null || obj.hashCode() == 0);
		
		System.out.println(true || false || false && false);
		
		System.out.println(5 < 6 && true || 2 * 5 == 11);
	}

}
