package com.skillstorm;

public class PassBy {

	public static void main(String[] args) {
		
		/**
		 * PASS BY VALUE vs. PASS BY REFERENCE
		 * 
		 * In Java, whenever you pass something to a method
		 * primitive values are passed as the values themselves
		 * whereas Objects (of any kind) are passed as the references
		 * 
		 * bit of a misnomer, because even a reference is still a value
		 * but, when passing by reference, changes to the properties of the passed Object
		 * inside the method WILL change the object referred to by the original variable
		 */
		
		int originalInt = 5;
		
		System.out.println(addTen(originalInt));
		
		System.out.println(originalInt);
		
		Book book1 = new Book("The Prince");
		
		System.out.println(book1);
		
		System.out.println(book1.title);
		
		changeTitle(book1);
		
		System.out.println(book1.title);
		
		

	}
	
	public static int addTen(int myInt) {
		
		myInt = myInt + 10;
		
		return myInt;
	}
	
	public static void changeTitle(Book book) {
		book.title = "The Little Prince";
		book = null;
	}

}

class Book {
	public String title;
	 
	public Book(String title) {
		this.title = title;
	}
	
	// a setter method for title
	public void setTitle(String title) {
		this.title = title;
	}
}



