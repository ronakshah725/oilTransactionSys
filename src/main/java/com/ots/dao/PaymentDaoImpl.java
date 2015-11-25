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
public class PaymentDaoImpl {

	 	public static final String QUERY_INSERT_TASK = "INSERT INTO payments(payment_id,client_id,trader_id,date_accepted ) VALUES (?,?,?,?)";
 


}

