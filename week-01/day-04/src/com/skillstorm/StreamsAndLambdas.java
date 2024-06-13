package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsAndLambdas {

	public static void main(String[] args) {
		
		// STREAMS AND LAMBDAS
		
		/*
		 * Streams are temporary sequences of items to be processed
		 * You can create a stream from a collection, process them, and the stream disappears
		 * The Stream is isolated from the original collection
		 * 
		 * Once a stream has been processed, you CANNOT go back it
		 * You must recreate it from the original collection if you wish to use it again
		 * Each set of stream actions MUST be concluded with a terminal operation
		 * 
		 * 
		 * Lambda Syntax
		 * (params) -> { body }
		 * 
		 * With no params, you must use (), like () -> { }
		 * With one param, you can use the parentheses or not, like (data) or data
		 * With more than one param, you have to use the parentheses (data1, data2)
		 * 
		 * If the method body is one line, the brackets aren't necessary, and the one line can't have a semicolon
		 * data -> methodX(data)
		 * If the method body is more than one line, you need brackets and semicolons
		 * 
		 * if you do the one-line bracketless version and are returning something, you can't use the return keyword
		 * 
		 */
		
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		
		Stream<Integer> stream = list.stream();
		
		// forEach
		// this takes each element in the stream and does something with it but returns nothing and ends the stream
		// terminal operation
		// requires a Consumer function, which is one that takes in data and does something with it but returns nothing (void return type)
		
		stream.forEach(data -> {
			System.out.println(data * data);
		});
		
		// can't do this, because the stream is closed and cannot be processed again
//		stream.forEach(data -> {
//			System.out.println(data * data);
//		});
		
		// map
		// this takes each element, does somethin with it, then returns something into a new stream that gets passed on
		// non-terminal operation
		// requires a Supplier function, which takes in data and returns something
		
		// needs a terminal operation to process, so we chain a forEach onto the end
		list.stream().map(data -> {
			System.out.println(data);
			return data * 10;
		})
		.forEach(data -> {
			System.out.println(data);
		});
		
		
		// filter
		// takes each element, and, if a condition about it is true, returns it unprocessed to the output stream
		// requires a Predicate, which tests a condition and returns a boolean
		// if the Predicate returns true, the element moves on to the output stream
		// if it's false, it's discarded (can change the overall number of elements)
		
		list.stream().filter(data -> {
			return data % 2 == 0;
		})
		.forEach(data -> {
			System.out.println(data);
		});
		
		
		// saving a function to a variable using an anonymous inner class
		// and implementing the abstract method test
//		Predicate p = new Predicate() {
//
//			@Override
//			public boolean test(Object t) {
//				
//				return (Integer)t % 2 == 0;
//			}
//			
//		};
//		
//		list.stream().filter(p).forEach(data -> System.out.println(data));
		
		
		
		// reduce
		// takes all the elements of the stream and returns a single value of some kind
		// this is also a terminal operation
		// requires an odd-looking function that takes two parameters
		
		// first param is an optional starting value, if you don't include it, the function may not return anything
		// second parameter is the function itself
		Integer x = list.stream().reduce(Integer.MIN_VALUE, (num1, num2) -> {
			return num1 > num2 ? num1 : num2;
		});
		
		System.out.println(x);
		
		// putting a few together by chaining
		list
		.stream()
		.map(data -> data * 7)
		.filter(data -> data >= 20)
		.forEach(data -> System.out.println(data));
		
		
		
		
		

	}

}
