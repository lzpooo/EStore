package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShoppingCar;

@WebServlet("/updateShopcart")
public class ShopcartUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		Long id = Long.parseLong(req.getParameter("id"));
		System.out.println(num);
		ShoppingCar shoppingCar = 
				(ShoppingCar) req.getSession().getAttribute("shoppingCar");
		System.out.println("......");
		shoppingCar.update(id, num);
		String path = "/user/shopcart.jsp";
		resp.sendRedirect(req.getContextPath()+path);
	}
}
