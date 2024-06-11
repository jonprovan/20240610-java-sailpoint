package com.skillstorm;

public class MethodSignatures {

	// we already laid out what's happening with the main method signature
	public static void main(String[] args) {
		
		String string1 = gimmeAString(10);
		System.out.println(string1);

	}
	
	// methods must be inside a class
	// signature -- <access modifier> <static - depends> <final - optional> <return type> methodName(<parameters - optional>) { method body }
	// no access modifier = default
	
	static String gimmeAString(int x) {
		String str = "";
		
		for(int i = 0; i < x; i++) {
			str = str + i;
		}
		
		return str;
	}
	

}
