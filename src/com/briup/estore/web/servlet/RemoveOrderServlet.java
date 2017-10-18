package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

@WebServlet("/removeOrder")
public class RemoveOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IOrderService orderService = new OrderServiceImpl();
		Long orderid= Long.parseLong(req.getParameter("orderid"));
		try {
			orderService.deleteOrder(orderid);
		} catch (OrderException e) {
			e.printStackTrace();
		}
		String path = "/user/order.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
