package com.skillstorm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		
		/*
		 * STACK AND QUEUE
		 * 
		 * Stack = LIFO
		 * - there is a Stack object, but we're not going to use it (old-fashioned)
		 * - will use a Deque (double-ended Queue instead)
		 * 
		 * Queue = FIFO
		 * - Queue is an interface; we need to use another collection to stand in for it (LinkedList)
		 */
		
		// can do this but won't
		// Stack<Integer> stack = new Stack<>();
		
		Deque<String> stack = new LinkedList<>();
		
		// push adds something to the stack
		stack.push("Nate");
		stack.push("Dustin");
		stack.push("Luis");
		
		// pop returns and removes the top element
		System.out.println(stack.pop());
		
		stack.push("Yuri");
		stack.push("Angelina");
		
		System.out.println(stack);
		
		// peek looks at the top element but doesn't remove it
		System.out.println(stack.peek());
		
		System.out.println(stack);
		
		// can add at a specific point in the stack by casting
		((LinkedList<String>)stack).add(2, "Rodney");
		
		System.out.println(stack);
		
		
		// Queue
		Queue<String> queue = new LinkedList<>();
		
		// offer places something at the end of the queue
		queue.offer("Gianni");
		queue.offer("Javier");
		queue.offer("Gabe");
		queue.offer("Jared");
		queue.offer("Noah");
		
		System.out.println(queue);
		
		// poll returns and removes something from the front of the queue
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		
		queue.offer("Chris");
		System.out.println(queue);
		
		// peek does the same thing as with stack -- looks at the first element without removing it
		System.out.println(queue.peek());
		System.out.println(queue);
	}

}
