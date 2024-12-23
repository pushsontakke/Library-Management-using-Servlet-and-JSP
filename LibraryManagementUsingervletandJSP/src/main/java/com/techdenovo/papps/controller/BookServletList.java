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

@WebServlet(urlPatterns = "/books")
public class BookServletList extends HttpServlet {
	BookDao bookDao = new BookDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = null;
		try {
			books = bookDao.allBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(books.size());
		req.setAttribute("books", books);
		req.getRequestDispatcher("list-book.jsp").forward(req, resp);
		
	}
	
//	@Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
}
