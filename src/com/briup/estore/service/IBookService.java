package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookException;

public interface IBookService {
	
	List<Book> listAllBooks() throws BookException ;
	Book findById(Long id) throws BookException;
}
