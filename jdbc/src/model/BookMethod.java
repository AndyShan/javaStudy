package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import util.DBUtil;

public class BookMethod {

	public void addBook(Book book) throws Exception {
		java.sql.Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into book_information" + "(name,price,author,id)" + "values(" + "?,?,?,?)";
		java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);//‘§±‡“Î
		
		ptmt.setString(1, book.getName());
		ptmt.setInt(2, book.getPrice());
		ptmt.setString(3, book.getAuthor());
		ptmt.setInt(4, book.getId());
		ptmt.execute();
	}

	public void updateBook() {

	}

	public void delBook() {

	}

	public List<Book> query() throws SQLException {
		java.sql.Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,price,name,author from book_information");

		List<Book> books = new ArrayList<Book>();
		Book book = null;
		while (rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getInt("price"));
			book.setAuthor(rs.getString("author"));
			books.add(book);
		}

		return books;
	}

	public Book get() {
		return null;
	}
}
