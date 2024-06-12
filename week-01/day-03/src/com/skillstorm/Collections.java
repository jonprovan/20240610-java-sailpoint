package com.skillstorm;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		
		/**
		 * COLLECTIONS IN JAVA
		 * 
		 * In general, we're talking about classes that collect objects/items together in some sort of organized group
		 * 
		 * Arrays
		 * - homogenous type
		 * - fixed size at instantiation
		 * - bracket notation for index-based access -- nums[0]
		 * - contiguous in memory, which provides constant-time access O(1)
		 * - iterable
		 * - O(n) search time
		 * - CAN have primitive values
		 * - memory-efficient
		 * 
		 * 
		 * Lists
		 * - homogenous type
		 * - ordered
		 * - not sorted until you sort them
		 * - do NOT allow primitives, so you must use objects, including wrapper classes for primitives
		 * - have common methods between them, like get(), add()
		 * - no index-based access
		 * - List is an interface, so the two main Lists we'll use are ArrayList and LinkedList
		 * 
		 * Stacks/Queues
		 * - Stack = LIFO, last in first out
		 * - Queue = FIFO, first in first out
		 * - Deque = double-ended queue (stands in for a Stack)
		 * - commonly instantiated as LinkedLists for their object type
		 * - PriorityQueue
		 * 
		 * 
		 * Sets
		 * - all unique elements -- no duplicates
		 * - Set is an interface, as is SortedSet
		 * - two that we'll see in practice are HashSet and TreeSet
		 * 
		 * Maps
		 * - based on key-value pairs
		 * - each entry will have a hashed key and a value of whatever you want to store
		 * - retrieval is based on the key -- ask for the key, get the value
		 * - access time is constant, ideally
		 * - collisions (same hash for different keys) are handled via hashcode/equals
		 * 
		 */
		
		// arrays
		int[] nums1; // more common
		int nums2[];
		int[] nums3 = new int[5];
		int[] nums4 = { 3, 1, 5, 2, 4 };
		
		// instantiated arrays with no given values get default values, like an Object's properties
		System.out.println(nums3[3]);
		
		nums3[3] = 10;
		
		// printing just prints the address
		System.out.println(nums3);
		
		// have to loop for values
		for (int num : nums3) {
			System.out.println(num);
		}
		
		// you can sort them
		Arrays.sort(nums4);
		
		for (int num : nums4) {
			System.out.println(num);
		}
		
		// multi-dimensional arrays
		// these are arrays within arrays, can act as a matrix
		
		int[][] grid = new int[3][3];
		grid[0][0] = 1;
		grid[2][1] = 8;
		
		int[][] grid2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		// looping through a 2-D array
		// loop labels applied as well
		
		// break stops the loop entirely
		// continue stops the current iteration and goes to the next
		OUTER: for (int i = 0; i < grid2.length; i++) {
			
			System.out.println("Outer Iteration " + (i+1));
			
			INNER: for (int j = 0; j < grid2[i].length; j++) {
				
				System.out.println("Inner Iteration " + (j+1));
				
				System.out.println(grid2[i][j]);
				
				if (grid2[i][j] == 5) {
					break OUTER;
				}
				
				if (j == 1) {
					break INNER;
				}
				
			}
			
		}
		
		// LISTS
		// ArrayList
		// these are resizable, meaning we can add/subtract items at will
		// underneath is an Array that gets recreated as the size expands/contracts
		// as a result, access time is comparable to an Array
		
		ArrayList<String> al1 = new ArrayList<>();
		List<String> al2 = new ArrayList<>();
		
		// adding values at the end
		al2.add("a");
		al2.add("b");
		al2.add("c");
		al2.add("d");
		al2.add("e");
		
		// retrieving a value
		System.out.println(al2.get(2));
		
		// adding a value at a specific spot
		al2.add(3, "cc");
		
		System.out.println(al2);
		
		// replacing a value
		al2.set(3, "ccc");
		
		System.out.println(al2);
		
		// removing a value
		al2.remove(3);
		
		System.out.println(al2);
		
		// sorting
		al2.set(2, "z");
		
		System.out.println(al2);
		
		// if you have two classes with the same name in different packages, you can choose which one to use like this
		// reverse domain name access to a specific class
		java.util.Collections.sort(al2);
		
		System.out.println(al2);
		
		
		// LinkedList
		// each element/node consists of 1. data/value, 2. pointers to the previous/next elements
		// each node lives separately in memory
		// access time is slow, because we have to walk through the pointers
		// insertion/removal time is fast, because we only have to change the previous/next pointers
		// same method set as ArrayList
		
		List<Integer> ll = new LinkedList<>();
		
		ll.add(5);
		ll.add(11);
		ll.add(21);
		ll.add(2);
		ll.add(-45);
		
		System.out.println(ll);
		
		// combining collections
		List<Object> ol = new LinkedList<>();
		
		ol.add(al2);
		ol.add(ll);
		
		
		Set<String> mySet = new HashSet<>();
		mySet.add("Pizza");
		System.out.println(mySet.contains("Pizza"));
		mySet.add("Pizza");
		
		System.out.println(mySet);
		
		
		
		

	}

}








