package com.skillstorm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Comparisons {

	public static void main(String[] args) {
		
		// COMPARISONS IN JAVA
		/*
		 * We've sorted collections before
		 * Some things, like numbers and Strings, have a "natural order"
		 */
		
		int[] nums = { 4, 89, 1, -23, 3 };
		Arrays.sort(nums);
		
		for (int num : nums) {
			System.out.println(num);
		}
		
		List<String> names = new LinkedList<>(Arrays.asList("Mike", "Sally", "Abigail", "Xena", "Larry"));
		Collections.sort(names);
		System.out.println(names);
		
		Book book1 = new Book("The Grapes of Wrath", 800, "Steinbeck");
		
		System.out.println(book1);
		
		Book book2 = new Book("Captain Underpants", 800, "Pilkey");
		Book book3 = new Book("Crime and Punishment", 950, "Dostoyevsky");
		Book book4 = new Book("Dune", 620, "Herbert");
		
		List<Book> bookList = new LinkedList<>(Arrays.asList(book1, book2, book3, book4));
		
		System.out.println(bookList);
		
		Collections.sort(bookList);
		
		System.out.println(bookList);
		
		Collections.sort(bookList, new AuthorComparator());
		
		System.out.println(bookList);
		
		Collections.sort(bookList, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				
				return o2.pageCount - o1.pageCount;
			}
			
		});
		
		System.out.println(bookList);

	}

}

// implementing the Comparable interface
class Book implements Comparable<Book> {
	
	public String title;
	public int pageCount;
	public String author;
	
	public Book(String title, int pageCount, String author) {
		super();
		this.title = title;
		this.pageCount = pageCount;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", pageCount=" + pageCount + ", author=" + author + "]";
	}

	@Override
	public int compareTo(Book other) {
		
//		if (this.pageCount > other.pageCount)
//			return 1;
//		if (this.pageCount == other.pageCount)
//			return 0;
//		else
//			return -1;
		
		if (this.pageCount - other.pageCount == 0)
			return this.title.compareTo(other.title);
		else
			return this.pageCount - other.pageCount;	
	}
}

// creating a separate class to do custom comparisons
class AuthorComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		
		if (b1.pageCount == b2.pageCount)
			return b1.author.compareTo(b2.author);
		else
			return b1.pageCount - b2.pageCount;
	}
	
}





