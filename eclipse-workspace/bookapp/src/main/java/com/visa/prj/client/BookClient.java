package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.BookDao;
import com.visa.prj.dao.BookDaoJDBCImpl;
import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.entity.Book;

public class BookClient {

	public static void main(String[] args) {
		while (true) {
			printOptions();
			int choice = KeyboardUtil.getInt("Select option: ");
			if (choice == 1) {
				
				Book book = new Book();
				BookDao bookdao = new BookDaoJDBCImpl();
				book.setId(0);
				book.setTitle("Hibernate In Action");
				book.setPrice(1200.00);
				book.getId();
				try {
					bookdao.addBook(book);
				} catch (PersistenceException e) {

					e.printStackTrace();
				}
				
			} else if (choice == 2) {
				BookDao bookdao = new BookDaoJDBCImpl();
				try {
					List<Book> books= bookdao.getBooks();
					for(Book b:books) {
						System.out.println(b.getTitle());
					}
				} catch (FetchException e) {
					
					e.printStackTrace();//development environment
					System.out.println(e.getMessage());
				}
			} else if (choice == 3) {
				System.exit(0);
			}
		}

	}

	private static void printOptions() {
		System.out.println("1:Add Book");
		System.out.println("2: List Books");
		System.out.println("3: Exit");
		System.out.println(("Select [1/2/3]"));
	}

}
