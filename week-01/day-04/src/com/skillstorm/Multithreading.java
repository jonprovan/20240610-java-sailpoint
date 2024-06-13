package com.skillstorm;

public class Multithreading {

	public static void main(String[] args) {
		
		// THREADS IN JAVA
		
		/*
		 * A thread is an object we need to instantiate
		 * 
		 * We feed in a Runnable which has an implemented run() method
		 * 
		 * To actually start the thread, we call start() on it, NOT run()
		 * run() will work but will just run in the main thread like any other method
		 * 
		 * your main method is running in its own thread!!
		 * 
		 */
		
		// not preferable, we need a Runnable
//		Thread thread = new Thread();
		
		// for the sleep example
//		Thread t1 = new Thread(new SimpleRun(1));
//		Thread t2 = new Thread(new SimpleRun(2));
//		Thread t3 = new Thread(new SimpleRun(3));
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
		Thread t1 = new Thread(new Incrementor());
		Thread t2 = new Thread(new Incrementor());
		Thread t3 = new Thread(new Incrementor());
		
		t1.start();
		t2.start();
		t3.start();
		
		// prints at some random time relative to the other threads like this
		System.out.println("Are we done?");
		
		// join() waits for that thread to be done before continuing in the main method/thread
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("How about now?");
		
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("NOW we're done!");
		
		

	}
	
	public static int counter = 0;
	
	// synchronized means that only one Thread can be inside this method at any given time
	public static synchronized void incrementCounter() {
		System.out.println(counter);
		counter++;
	}
	
	// creating a shared object we can use to lock out specific areas of code
	public static final Object mutex = new Object();
	
	

}

class SimpleRun implements Runnable {
	
	int threadNumber;
	
	public SimpleRun(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		
		// this makes the current thread wait a certain amount of time before continuing
		try {
			Thread.sleep(1000 * this.threadNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 10; i++)
			System.out.println("Thread " + this.threadNumber + ": " + i);
		
	}
	
}

class Incrementor implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
//			System.out.println(Multithreading.counter);
//			Multithreading.counter++;
			
//			Multithreading.incrementCounter();
			
			synchronized (Multithreading.mutex) {
				System.out.println(Multithreading.counter);
				Multithreading.counter++;
			}
		}
		
	}
	
}




