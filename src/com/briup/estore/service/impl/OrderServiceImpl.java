package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Order;
import com.briup.estore.common.MyBatisSqlSessionFactory;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.dao.IOrderDao;
import com.briup.estore.service.IOrderService;

public class OrderServiceImpl implements IOrderService{

	@Override
	public void savaOrder(Order order) throws OrderException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		IOrderDao mapper = session.getMapper(IOrderDao.class);
		mapper.saveOrder(order);
	}

	@Override
	public void deleteOrder(Long id) throws OrderException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		IOrderDao mapper = session.getMapper(IOrderDao.class);
		mapper.deleteOrderById(id);
	}

	@Override
	public Order findById(Long id) throws OrderException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		IOrderDao mapper = session.getMapper(IOrderDao.class);
		Order order = mapper.findOrderById(id);
		return order;
	}

	@Override
	public List<Order> findByCustomerId(Long id) throws OrderException {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		IOrderDao mapper = session.getMapper(IOrderDao.class);
		List<Order> list = mapper.findOrderByCustomerId(id);
		return list;
	}

}
