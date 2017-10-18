package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

@WebServlet("/updateCustomer")
public class CustomerUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		Customer customer = new Customer(id, name, password, zip, address, telephone, email);
		String path = "/user/userinfo.jsp";
		String msg = "";
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.updateCustomer(customer);
			req.getSession().setAttribute("customer", customer);
			msg = "修改成功";
		} catch (CustomerException e) {
			e.printStackTrace();
			msg = "修改失败:"+e.getMessage();
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+path);
	}
}
