package com.briup.estore.dao;

import java.util.List;


import com.briup.estore.bean.Book;

public interface IBookDao  {
	public List<Book> queryAll();
	public Book queryById(Long id);
}
