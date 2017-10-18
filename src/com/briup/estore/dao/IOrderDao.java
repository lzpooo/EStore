package com.briup.estore.dao;


import java.util.List;

import com.briup.estore.bean.Order;

public interface IOrderDao  {
	public void saveOrder(Order order);
	public Order findOrderById(Long id);
	public List<Order> findOrderByCustomerId(Long id);
	public void deleteOrderById(long orderId);
}
