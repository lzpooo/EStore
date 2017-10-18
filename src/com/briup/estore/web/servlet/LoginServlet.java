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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userid");
		String password = req.getParameter("password");
		ICustomerService service = new CustomerServiceImpl();
		try {
			if (name != null && password != null) {
				Customer customer = service.login(name, password);
				if(customer !=null){
					if(customer.getPassword().equals(password)){
						req.getSession().setAttribute("customer", customer);
						resp.sendRedirect(req.getContextPath() + "/index.jsp");
					}else {
						System.out.println("密码错误！");
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
					}
				}else{
					System.out.println("用户名不存在！");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}else {
				System.out.println("用户名或密码不能为空！");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
}
