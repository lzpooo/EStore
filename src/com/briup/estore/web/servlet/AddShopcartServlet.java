package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

@WebServlet("/shopcartAdd")
public class AddShopcartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		String path = "/user/shopcart.jsp";
		IBookService bookService = new BookServiceImpl();
		if (req.getSession().getAttribute("shoppingCar")==null) {
			ShoppingCar sc = new ShoppingCar();
			req.getSession().setAttribute("shoppingCar", sc);
		}
		try {
			ShoppingCar shoppingcar = 
					(ShoppingCar) req.getSession().getAttribute("shoppingCar");
			Book book = bookService.findById(id);
			Line line = new Line();
			line.setBook(book);
			if (line != null) {
				shoppingcar.add(line);
			}
		} catch (BookException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
}
