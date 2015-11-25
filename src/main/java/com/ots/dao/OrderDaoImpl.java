/**
 * 
 */
package com.ots.dao;

import org.springframework.stereotype.Repository;

/**
 * @author kanchan
 *
 */

@Repository
public class OrderDaoImpl {

	 	public static final String QUERY_INSERT_TASK = "INSERT INTO orders(id,type,trans_fee,quantity,commission_fees,commission_type,total_amt,oil_adjusted_quantity,date_placed ) VALUES (?,?,?,?,?,?,?,?,?)";
	 	public static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders where order_id IN (SELECT order_id FROM places where client_id=?)";
	 	public static final String UPDATE_ORDER = "UPDATE orders SET payment_id = ? WHERE order_id in (?)";
 


}

