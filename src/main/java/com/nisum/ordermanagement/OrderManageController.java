/**
 * 
 */
package com.nisum.ordermanagement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.ordermanagement.model.Order;
import com.nisum.ordermanagement.service.OrderManageService;

/**
 * @author SVadikari
 *
 */

@RestController
public class OrderManageController {

	@Autowired
	private OrderManageService orderManageServie;

	@GetMapping
	public Collection<Order> getOrders() {
		return orderManageServie.getOrders();
	}

	@GetMapping("/{orderNumber}")
	public Order getOrder(@PathVariable String orderNumber) {
		return orderManageServie.getOrder(orderNumber);
	}
	
	@PostMapping
	public String createOrder(@RequestBody Order order) {
		orderManageServie.createOrder(order);
		return "success";
	}

	@DeleteMapping("/{orderNumber}")
	public String deleteOrder(@PathVariable String orderNumber) {
		return orderManageServie.deleteOrder(orderNumber) ? "deleted" : "order doesn't exists";

	}

	@PutMapping
	public String updateOrder(@RequestBody Order order) {
		return orderManageServie.updateOrder(order) ? "updated" : "order doesn't exists";
	}
}
