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
	
	public List<Book> allBooks(){
		List<Book> books = new ArrayList<>();
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
					book.setIsbn(rs.getString("ISBN_NUMBER"));
					books.add(book);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
			return books;
	}
	
	public int addBook(Book book) {
		Connection conn = dbUtil.getDbConnection();
			try {
				String query = "INSERT INTO BOOKS (BOOK_NAME, AUTHOR_NAME, ISBN_NUMBER) VALUES(?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, book.getBookName());
				ps.setString(2, book.getAuthorName());
				ps.setString(3, book.getIsbn());
				int isBookAdd = ps.executeUpdate();
				
				if(isBookAdd == 1) {
					System.out.println("Book details added successfully.");
				} else {
					System.out.println("Fail to add book details.");
				}
				
				conn.close();
				return isBookAdd;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		
	}
}