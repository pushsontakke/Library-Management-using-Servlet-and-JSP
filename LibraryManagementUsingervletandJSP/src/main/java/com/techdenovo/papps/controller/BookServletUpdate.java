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

@WebServlet("/update-book")
public class BookServletUpdate extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("update-button");
		Book book = new Book();
		BookDao bookDao = new BookDao();
		long bookId = Integer.parseInt(id);
		try {
			book = bookDao.getBookDetail(bookId);
			req.setAttribute("book", book);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean flag = false;
		String id = req.getParameter("id");
//		System.out.println("i got hit. with id = "+ id);
		long bookId = Integer.parseInt(id);
		String bookName = req.getParameter("book-name");
		String authorName = req.getParameter("author-name");
		String isbn = req.getParameter("isbn");
		
		BookDao bookDao = new BookDao();
		
		try {
			flag = bookDao.updateBookDetail(bookId, bookName, authorName, isbn);
//			System.out.println(flag);
			
			if(flag) {
				resp.sendRedirect("books");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}





