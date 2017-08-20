package com.nisum.ordermanagement.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nisum.ordermanagement.model.Order;
import com.nisum.ordermanagement.service.OrderManageService;

@Service
public class OrderManageServiceImpl implements OrderManageService {
	Map<String, Order> ordersMapDb = new HashMap<>();

	public Collection<Order> getOrders() {
		return ordersMapDb.values();
	}

	public Order getOrder(String orderNumber) {
		return ordersMapDb.get(orderNumber);
	}

	public void createOrder(Order order) {
		ordersMapDb.put(order.getOrderNumber(), order);
	}

	public boolean deleteOrder(String orderNumber) {
		return ordersMapDb.remove(orderNumber) == null ? false : true;
	}

	public boolean updateOrder(Order order) {
		if (ordersMapDb.containsKey(order.getOrderNumber())) {
			ordersMapDb.put(order.getOrderNumber(), order);
			return true;
		}
		return false;
	}
}
