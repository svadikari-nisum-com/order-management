/**
 * 
 */
package com.nisum.ordermanagement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nisum.ordermanagement.model.Order;

/**
 * @author SVadikari
 *
 */
public interface OrderManageRepository extends MongoRepository<Order, String>{

	Order getByOrderNumber(String orderNumber);

}
