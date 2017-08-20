/**
 * 
 */
package com.nisum.ordermanagement.model;

import java.math.BigDecimal;

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

	  private String orderNumber;
	  private String orderDate;
	  private Integer itemsQty;
	  private BigDecimal itemPrice;
}
