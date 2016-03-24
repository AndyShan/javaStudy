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
		java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);// ‘§±‡“Î

		ptmt.setString(1, book.getName());
		ptmt.setInt(2, book.getPrice());
		ptmt.setString(3, book.getAuthor());
		ptmt.setInt(4, book.getId());
		ptmt.execute();
	}

	public void updateBook(Book book) throws Exception {
		java.sql.Connection conn = DBUtil.getConnection();
		String sql = "" + " update book_information " 
		+ " set name=?,price=?,author=? " 
		+ " where id=? ";
		java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);// ‘§±‡“Î

		ptmt.setString(1, book.getName());
		ptmt.setInt(2, book.getPrice());
		ptmt.setString(3, book.getAuthor());
		ptmt.setInt(4, book.getId());
		ptmt.execute();
	}

	public void delBook(int id) throws Exception{
		java.sql.Connection conn = DBUtil.getConnection();
		String sql = "" + " delete from book_information " 
		+ " where id=? ";
		java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);// ‘§±‡“Î

		ptmt.setInt(1, id);
		ptmt.execute();
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

	public Book get(Integer id) throws Exception{
		Book b = null;
		java.sql.Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from book_information " 
		+ " where id=? ";
		java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);// ‘§±‡“Î

		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			b = new Book();
			b.setId(rs.getInt("id"));
			b.setAuthor(rs.getString("author"));
			b.setName(rs.getString("name"));
			b.setPrice(rs.getInt("price"));
		}
		return b;
	}
}
