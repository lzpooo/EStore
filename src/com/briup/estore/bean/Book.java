package com.briup.estore.bean;

import java.io.Serializable;
/**
 * 
 * @ClassName: Book	书籍类
 *
 */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	
	public Book(){
		
	}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
