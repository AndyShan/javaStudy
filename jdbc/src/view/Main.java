package view;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import model.BookMethod;

public class Main {
	public static void main(String args[]) throws Exception {
		BookMethod control = new BookMethod();
		List<Book> book = control.query();
		Book newBook = new Book();
		newBook.setAuthor("Ê©ÄÍâÖ");
		newBook.setName("Ë®ä°´«");
		newBook.setPrice(100);
		newBook.setId(4);
		control.addBook(newBook);
		for (Book b : book) {
			System.out.println("name:"+b.getName()+" id:"+b.getId()+" price:"+b.getPrice()+" author:"+b.getAuthor());
		}
		
	}
}
