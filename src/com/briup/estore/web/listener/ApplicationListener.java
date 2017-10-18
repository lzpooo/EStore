package com.briup.estore.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		IBookService bookService=new BookServiceImpl();
		try {
			List<Book> books = bookService.listAllBooks();
			ServletContext servletContext = sce.getServletContext();
			servletContext.setAttribute("books", books);
		} catch (BookException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
