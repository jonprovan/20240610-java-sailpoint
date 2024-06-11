package com.skillstorm;

import java.util.ArrayList;

public class StackHeap {

	public static void main(String[] args) {
		
		int x = 10;
		double y = 12.34;
		char z = '9';
		
		int otherInt = doubleInt(x);
		
		System.out.println(otherInt);
		
		Object myObject = getObject();
		
		System.out.println(myObject);
		
		Animal animal1 = new Animal("Randall", "Shark");
		
		System.out.println(animal1);
		
		animal1.name = "Grizelda";
		
		System.out.println(animal1);
		
		String localName = animal1.name;
		
		Animal[] animalArray = { new Animal("a", "b"), new Animal("c", "d"), new Animal("e", "f") };
		
		System.out.println(animalArray[0]);
		
		ArrayList<Animal> animalAL = new ArrayList<>();
		
		animalAL.add(new Animal("a", "b"));
		
		System.out.println(animalAL);
		System.out.println(animalAL.get(0));
		
		animalAL.get(0).name = "Joe";
		
		System.out.println(animalAL.get(0).name);
		
		// this would remove the last reference to Joe, so he's gone forever
		animalAL.add(0, null);
		
		String otherString = "abc";
		
		

	}
	
	public static int doubleInt(int myInt) {
		return myInt*2;
	}
	
	public static Object getObject() {
		return new Object();
	}

}

// can't have more than one public class per file
class Animal {
	
	public String name;
	public String species;
	
	public Animal() {
		
	}
	
	public Animal(String name, String species) {
		this.name = name;
		this.species = species;
	}
	
}







