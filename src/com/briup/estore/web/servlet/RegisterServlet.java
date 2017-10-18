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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		if (name!=null) {
			if (password!=null) {
				try {
					Customer customer = new Customer();
					customer.setName(name);
					customer.setPassword(password);
					customer.setAddress(address);
					customer.setEmail(email);
					customer.setTelephone(telephone);
					customer.setZip(zip);
					ICustomerService service = new CustomerServiceImpl();
					service.register(customer);
					resp.sendRedirect(req.getContextPath() + "/login.jsp");
				} catch (CustomerException e) {
					e.printStackTrace();
					req.getRequestDispatcher("/register.jsp").forward(req, resp);
				}
			}else {
				System.out.println("密码不能为空！");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			}
		}else {
			System.out.println("用户名不能为空！");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
		
	}
}
