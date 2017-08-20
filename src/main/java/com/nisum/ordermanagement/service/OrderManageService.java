package com.nisum.ordermanagement.service;

import java.util.Collection;

import com.nisum.ordermanagement.model.Order;

public interface OrderManageService {

	public Collection<Order> getOrders();
	public Order getOrder(String orderNumber);
	public void createOrder(Order order);
	public boolean deleteOrder(String orderNumber);
	public boolean updateOrder(Order order);
}
