package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetAndMap {

	public static void main(String[] args) {
		
		// SETS AND MAPS
		
		/*
		 * Sets have no duplicates
		 * - HashSet and TreeSet
		 * 
		 * 
		 * Maps are key-value based
		 * HashMap
		 * TreeMap, LinkedHashMap, etc.
		 */
		
		// creating a Set - Set itself is an interface, so we can't instatiate it without a child class object
		// Set<String> = new Set<>(); // can't do this
		
		Set<String> set = new HashSet<>();
		
		System.out.println(set);
		
		set.add("ABC");
		set.add("XYZ");
		set.add("LMN");
		set.add("DEF");
		
		// HashSet is neither ordered nor sorted
		// you can't guarantee the order, even when just calling it multiple times
		System.out.println(set);
		
		String str = "LMN";
		System.out.println(set.contains(str));
		
		// can add entire collections
		// 
		List<String> ll = new LinkedList<>(Arrays.asList("Cat", "Bat", "Rat", "ABC", "DEF"));
		
		// add methods return booleans, depending on whether or not the set was changed
		boolean didItWork = set.addAll(ll);
		System.out.println(didItWork);
		
		System.out.println(set);
		
		// checking if set contains ALL of the items I'm asking about
		System.out.println(set.containsAll(Arrays.asList("Cat", "XY")));
		
		// TreeSet is ordered and sorted, either by natural order or some ordering we design
		Set<Integer> ts = new TreeSet<>();
		
		ts.add(6);
		ts.add(-12);
		ts.add(77);
		ts.add(2);
		ts.add(1567);
		
		System.out.println(ts);
		
		// iterating through sets
		// can't use standard for loop, because there are no keys or indices
		
		for (Integer i : ts) {
			// ts.remove(i);
			System.out.println(i);
		}
		
		// Sets also have the ability to generate an Iterator, so we can step through them
		
		Iterator<String> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			// set.remove(iterator.next());
			System.out.println(iterator.next());
		}
		System.out.println("All Done!");
		
		
		
		// Maps
		// key-value pairs, and we need to give it a type for the key as well as the value
		
		Map<String, Integer> employeeMap = new HashMap<>();
		employeeMap.put("Luis", 12345);
		employeeMap.put("Jared", 67890);
		employeeMap.put("Noah", 55555);
		employeeMap.put("Jared", 99999);
		
		System.out.println(employeeMap.get("Jared"));
		
		// Objects get hashed to create the actual keys
		// we don't need to remember what they are
		System.out.println("Noah".hashCode());
		
		System.out.println("" + "FB".hashCode() + " " + "Ea".hashCode());
		
		// we need to override .hashcode() and .equals() to have this work properly with our objects
		Mug mug1 = new Mug(16, "Blue");
		Mug mug2 = new Mug(16, "Blue");
		
		// these are not equal, because they're different instances
		// but we want them to appear as equal
		System.out.println(mug1 == mug2);
		System.out.println(mug1.equals(mug2)); // returns true with properly-overridden method in our class
		System.out.println(mug1);
		System.out.println(mug2);
		
		Map<Mug, Integer> mugCount = new HashMap<>();
		
		// without properly overridden hashcode/equals methods, these create two separate entries
		// but we want all mugs with the same properties to be considered equal
		mugCount.put(mug1, 45);
		mugCount.put(mug2, 75);
		
		Mug mug3 = new Mug(16, "Blue");
		
		// this mug was never part of the process until now, but it's equal, per our overridden methods, so...
		System.out.println(mugCount.get(mug3)); // returns 75

	}

}

class Mug {
	public int volume;
	public String color;
	
	public Mug(int volume, String color) {
		this.volume = volume;
		this.color = color;
	}

	// this makes the hashcodes the same for mugs with identical properties
	@Override
	public int hashCode() {
		return Objects.hash(volume * 37 - 12 + color.hashCode());
	}

	// this makes sure mugs with identical properties are considered equal
	@Override
	// takes in another Object to compare it to
	public boolean equals(Object obj) {
		// checks if the two objects are the same instance
		if (this == obj)
			return true;
		// checks if the other object is null
		if (obj == null)
			return false;
		// checks if the instance class type is the same
		if (getClass() != obj.getClass())
			return false;
		// casting the other object as a Mug to get access to its properties
		Mug other = (Mug) obj;
		// is the volume of the other Mug equal to this one
		// other things we're checking would appear here
		return volume == other.volume && color.equals(other.color);
	}
	
	
	
}








