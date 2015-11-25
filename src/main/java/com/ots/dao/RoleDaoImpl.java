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
public class RoleDaoImpl {

	 	public static final String QUERY_INSERT_TASK = "INSERT INTO role(id,role_code) VALUES (?,?)";
	 	public static final String SELECT_ROLE_BY_ID = "SELECT * FROM role";

 


}
