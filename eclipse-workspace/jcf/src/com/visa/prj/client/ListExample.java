package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.visa.prj.entity.Book;

public class ListExample {
	
	public static void main(String args[]) {
		List<Book> books= new ArrayList<>();
		//List<Book> books= new ArrayList<Book>();
		//ArrayList<Book> books= new ArrayList<>();
		//List<Book> books= new LinkedList<Book>();
		
		books.add(new Book(144,"Hibernate in Action",1200.00));
		books.add(new Book(809,"ALchemist",890.00));
		books.add(new Book(713,"Java",500.00));
		books.add(new Book(623,"GOT",900.00));
		
		Collections.sort(books,(o1,o2)->o1.getTitle().compareTo(o2.getTitle()));
		for(Book b:books) {
			System.out.println(b);
		}
	}
}
