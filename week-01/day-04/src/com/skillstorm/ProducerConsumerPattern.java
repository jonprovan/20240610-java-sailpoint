package com.skillstorm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerPattern {

	public static void main(String[] args) {
		/*
		 * PRODUCER-CONSUMER PATTERN
		 * 
		 * Multiple producers add to a shared resource
		 * Multiple consumers take from a shared resource
		 * 
		 * Takes some setup!
		 */
		
		Thread p1 = new Thread(new Producer());
		Thread p2 = new Thread(new Producer());
		Thread p3 = new Thread(new Producer());
		
		Thread c1 = new Thread(new Consumer());
		Thread c2 = new Thread(new Consumer());
		Thread c3 = new Thread(new Consumer());
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
		
		
		

	}
	
	public static Queue<Integer> queue = new LinkedList<>();
	
	// ArrayBlockingQueue has a fixed length that we give it
	// items added after that will be skipped
	// public static Queue<Integer> queue = new ArrayBlockingQueue<>(5);
	
	public static Integer counter = 1;
	
	public static synchronized void produce() {
		queue.offer(counter++);
		System.out.println("Producer produced: " + queue + "\n");
	}
	
	public static synchronized void consume() {
		System.out.println("Consumer consumed: " + queue.poll());
		System.out.println(queue + "\n");
	}

}

class Producer implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ProducerConsumerPattern.produce();
		}
		
	}
	
}

class Consumer implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ProducerConsumerPattern.consume();
		}
		
	}
	
}






