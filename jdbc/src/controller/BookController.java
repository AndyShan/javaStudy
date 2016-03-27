package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import model.BookMethod;

public class BookController {
	public void add(Book book) throws Exception {
		BookMethod bookMtthod = new BookMethod();
		bookMtthod.addBook(book);
	}
	
	public void edit(Book book) throws Exception {
		BookMethod bookMethod = new BookMethod();
		bookMethod.updateBook(book);
	}
	
	public void del(int id) throws Exception {
		BookMethod bookMethod = new BookMethod();
		bookMethod.delBook(id);
	}
	
	public List<Book> query() throws Exception {
		BookMethod bookMethod = new BookMethod();
		return bookMethod.query();
	}

	public Book get(int id) throws Exception {
		BookMethod bookMethod = new BookMethod();
		return bookMethod.get(id);
	}
	
	
	
}
