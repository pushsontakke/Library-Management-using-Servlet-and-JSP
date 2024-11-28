package com.techdenovo.papps.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.techdenovo.papps.dao.BookDao;
import com.techdenovo.papps.model.Book;

@WebServlet(urlPatterns = "/book-add")
public class BookServletAdd extends HttpServlet {
	BookDao bookDao = new BookDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		System.out.println(books.size());
		
		req.getRequestDispatcher("form.jsp").forward(req, resp);
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book();
		
		if(!req.getParameter("book-name").isEmpty()) {
			book.setBookName(req.getParameter("book-name"));
			book.setAuthorName(req.getParameter("author-name"));
			book.setIsbn(req.getParameter("isbn"));
		}
		try {
			bookDao.addBook(book);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("books");
	}
}
