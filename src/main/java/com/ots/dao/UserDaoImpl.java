/**
 * 
 */
package com.ots.dao;

/**
 * @author kanchan
 *
 */
public class UserDaoImpl {
 

    public static final String SELECT_USER_BY_CREDS = "SELECT * FROM user WHERE email= ? and password=?";
    
    public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE email= ? ";
    
    public static final String QUERY_INSERT_TASK = "INSERT INTO user(id,first_name,last_name) VALUES (?,?,?)";
 
}
