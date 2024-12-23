package com.techdenovo.papps.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techdenovo.papps.dao.BookDao;
import com.techdenovo.papps.model.Book;

@WebServlet("/books-details")
public class BookServletRead extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
//		System.out.println(Id);
		BookDao bookDao = new BookDao();
		long bookId = Integer.parseInt(id);
		Book book = null;
		try {
			book = bookDao.getBookDetail(bookId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("book", book);
		req.getRequestDispatcher("book-details.jsp").forward(req, resp);
		
	}
	
	
}




