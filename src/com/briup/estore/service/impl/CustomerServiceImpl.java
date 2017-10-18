package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.MyBatisSqlSessionFactory;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void register(Customer customer) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		ICustomerDao mapper = session.getMapper(ICustomerDao.class);
		if(mapper.findByName(customer.getName()) !=null){
			throw new CustomerException("用户名已存在！");
		}else{
			mapper.saveCustomer(customer);
		}
		session.close();
	}
	
	@Override
	public Customer login(String name, String password) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		ICustomerDao mapper = session.getMapper(ICustomerDao.class);
		Customer customer = mapper.findByName(name);
		session.close();
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		ICustomerDao mapper = session.getMapper(ICustomerDao.class);
		try {
			mapper.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new CustomerException(e.getMessage());
		}finally {
			session.close();
		}
	}

}
