package com.skillstorm;

public class InheritanceRedux {

	public static void main(String[] args) {
		/**
		 * 			Vehicle
		 * 			/	  \
		 * 		Car		Truck
		 * 		/\
		 * Sedan  Coupe
		 */					

	}

}

class PrizedPosession {
	
}

class Vehicle {
	
}

// can't extend from more than one class
//class Car extends Vehicle, PrizedPosession {
class Car extends Vehicle {	

}

// but I can extend from one class as many times as I like
class Truck extends Vehicle {
	
}

class Sedan extends Car {
	
}

class Coupe extends Car {
	
}
