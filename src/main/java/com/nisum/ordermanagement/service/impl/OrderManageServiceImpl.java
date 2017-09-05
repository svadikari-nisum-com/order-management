package com.nisum.ordermanagement.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.ordermanagement.dao.OrderManageRepository;
import com.nisum.ordermanagement.model.Order;
import com.nisum.ordermanagement.service.OrderManageService;

@Service
public class OrderManageServiceImpl implements OrderManageService {
	Map<String, Order> ordersMapDb = new HashMap<>();

	@Autowired
	private OrderManageRepository orderManageRepository;
	
	public Collection<Order> getOrders() {
		//return ordersMapDb.values();
		return orderManageRepository.findAll();
	}

	public Order getOrder(String orderNumber) {
		//return ordersMapDb.get(orderNumber);
		return orderManageRepository.getByOrderNumber(orderNumber);
	}

	public void createOrder(Order order) {
		//ordersMapDb.put(order.getOrderNumber(), order);
		orderManageRepository.save(order);
	}

	public boolean deleteOrder(String orderNumber) {
		//return ordersMapDb.remove(orderNumber) == null ? false : true;
		orderManageRepository.delete(orderManageRepository.getByOrderNumber(orderNumber));
		return true;
	}

	public boolean updateOrder(Order order) {
		orderManageRepository.save(order);
		return true;
	}
}
