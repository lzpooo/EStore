package com.briup.estore.dao;


import com.briup.estore.bean.Customer;

public interface ICustomerDao  {
	public Customer findByName(String name);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
}
