package com.techdenovo.papps.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.techdenovo.papps.model.Book;
import com.techdenovo.papps.utils.DbUtil;

public class BookDao {
	DbUtil dbUtil = new DbUtil();
	
	public List<Book> allBooks() throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<Book>();
		Connection conn = dbUtil.getDbConnection();
		if(conn != null) {
			try {
				String query = "SELECT * FROM BOOKS";
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery(); // select Query
				while(rs.next()) {
					Book book = new Book();
					book.setId(rs.getLong("ID"));
					book.setBookName(rs.getString("BOOK_NAME"));
					book.setAuthorName(rs.getString("AUTHOR_NAME"));
					book.setIsbn(rs.getString("ISBN"));
					books.add(book);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		conn.close();
		return books;
	}
	
	public boolean addBook(Book book) throws ClassNotFoundException, SQLException {
		Connection conn = dbUtil.getDbConnection();
			try {
				String query = "INSERT INTO BOOKS (BOOK_NAME, AUTHOR_NAME, ISBN) VALUES(?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, book.getBookName());
				ps.setString(2, book.getAuthorName());
				ps.setString(3, book.getIsbn());
				int isBookAdd = ps.executeUpdate();
				
//				if(isBookAdd == 1) {
//					System.out.println("Book details added successfully.");
//				} else {
//					System.out.println("Fail to add book details.");
//				}
				
				conn.close();
				return isBookAdd > 0;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	public Book getBookDetail(long id) throws ClassNotFoundException, SQLException {
		Connection conn = dbUtil.getDbConnection();
		Book book = new Book();
		if(conn != null) {
				String query = "SELECT * FROM BOOKS WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery(); 
				if(rs.next()) {
					book.setId(rs.getLong("ID"));
					book.setBookName(rs.getString("BOOK_NAME"));
					book.setAuthorName(rs.getString("AUTHOR_NAME"));
					book.setIsbn(rs.getString("ISBN"));
				}
			}
		return book;
		}
	
	public boolean deleteBook(long id) throws ClassNotFoundException, SQLException {
		Connection conn = dbUtil.getDbConnection();
		boolean flag = false;
		if(conn != null) {
			String query = "DELETE FROM books WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			int isBookDeleted = ps.executeUpdate();
			if(isBookDeleted > 0) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean updateBookDetail(long id, String name, String author, String isbn) throws ClassNotFoundException, SQLException {
		Connection conn = dbUtil.getDbConnection();
		String query = "UPDATE books SET BOOK_NAME = ?, AUTHOR_NAME = ?, ISBN = ? WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, author);
		ps.setString(3, isbn);
		ps.setLong(4, id);
		
		int isBookUpdated = ps.executeUpdate();
		
		conn.close();
		return isBookUpdated > 0;
	}
	
	
	
	
}





