package com.techdenovo.papps.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techdenovo.papps.dao.BookDao;

@WebServlet("/delete-book")
public class BookServletDelete extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("delete-button");
//		System.out.println(Id);
		long bookId = Integer.parseInt(id);
		BookDao bookDao = new BookDao();
		
		try {
			if(bookDao.deleteBook(bookId)) {
				resp.sendRedirect("/LibraryManagementUsingervletandJSP");
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
