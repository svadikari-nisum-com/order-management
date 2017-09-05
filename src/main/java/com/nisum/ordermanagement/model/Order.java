/**
 * 
 */
package com.nisum.ordermanagement.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SVadikari
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class Order {

	@Id
	private String id;
	private String orderNumber;
	private String orderDate;
	private Integer itemsQty;
	private BigDecimal itemPrice;
}
