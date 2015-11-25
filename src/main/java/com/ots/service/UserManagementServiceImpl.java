package com.ots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ots.common.UserBean;
import com.ots.dao.UserDaoImpl;

/**
 * This service will be used for supporting UserManagement and login tasks 
 * @author kanchan
 *
 */
@Service
public class UserManagementServiceImpl {

@Autowired
private UserDaoImpl userDao;

/**
 * This method validates whether user's credentials are correct or not and if not, it returns the null object.
 * @param userName
 * @param password
 * @return
 */
public UserBean validateAndFetchUserDetails(String userName,String password)
{
	UserBean user = userDao.getUserDetails(userName, password);
	if(user!=null)
	{
		user.setPassword(null);
	}
	return user;
}


}
