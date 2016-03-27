package view;

import java.sql.SQLException;
import java.util.List;

import controller.BookController;
import model.Book;
import model.BookMethod;

public class Main {
	public static void main(String args[]) throws Exception {
		BookController controller = new BookController();
		List<Book> books = controller.query();

		for (Book i : books) {
			System.out.print(i.getId() + " ");
			System.out.print(i.getName() + " ");
			System.out.print(i.getPrice() + " ");
			System.out.print(i.getAuthor() + " ");
		}
	}
}
