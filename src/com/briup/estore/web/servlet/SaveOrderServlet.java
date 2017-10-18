package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

@WebServlet("/saveOrder")
public class SaveOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShoppingCar shoppingcar = 
				(ShoppingCar) req.getSession().getAttribute("shoppingCar");
		Customer customer = 
				(Customer)req.getSession().getAttribute("customer");
		double cost = shoppingcar.getCost();
		Map<Long, Line> map = shoppingcar.getLines();
		Order order = new Order();
		order.setCost(cost);
		order.setCustomer(customer);
		order.setOrderDate(new Date());
		order.setLines(map.values());
		req.getSession().setAttribute("order", order);
		IOrderService orderService = new OrderServiceImpl();
		String path = "";
		String msg = "";
		try {
			orderService.savaOrder(order);
			path = "/orderFindAll";
			msg = "订单提交成功";
		} catch (OrderException e) {
			e.printStackTrace();
			path = "/user/confirmOrder.jsp";
			msg = "订单提交失败:"+e.getMessage();
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+path);
	}
}
