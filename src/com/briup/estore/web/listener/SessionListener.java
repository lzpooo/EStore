package com.briup.estore.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.estore.bean.ShoppingCar;

@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ShoppingCar sc = new ShoppingCar();
		HttpSession session = se.getSession();
		session.setAttribute("shoppingCar", sc);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
