package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ots.common.ClientBean;
import com.ots.common.TraderBean;
import com.ots.common.UserBean;
import com.ots.dao.UserDaoImpl;

/**
 * This service will be used for supporting UserManagement and login tasks
 * 
 * @author kanchan
 *
 */
@Service
public class UserManagementServiceImpl {

	@Autowired
	private UserDaoImpl userDao;

	/**
	 * This method validates whether user's credentials are correct or not and
	 * if not, it returns the null object.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserBean validateAndFetchUserDetails(String userName, String password) {
		UserBean user = userDao.getUserDetails(userName, password);
		if (user != null) {
			user.setPassword(null);
		}
		return user;
	}

	/**
	 * This method executes a select query on Client table by id and returns the
	 * bean as output
	 * 
	 * @param userId
	 * @return
	 */
	public ClientBean getClientDetails(String userId) {
		ClientBean bean = null;
		
		// bean = return result of ClientDaoImpl.getClientDeatils(userId);
		return bean;
	}

	/**
	 * This method executes a select query on Trader table by id and returns the
	 * bean as output
	 * 
	 * @param userId
	 * @return
	 */
	public TraderBean getTraderDetails(String userId) {
		TraderBean bean = null;
		// bean = return result of ClientDaoImpl.getClientDeatils(userId);
		return bean;
	}

	/**
	 * This function loops through all the feature codes available for Client
	 * role and returns the same.
	 * 
	 * @return
	 */
	public List<String> getClientFeatureCodes() {
		List<String> listOfFeatures = null;
		
		// Following query can be directly written in featureDaoImpl - no need to create a separate role_daoimpl/role_has_user_daoimpl
		// select f.feature_code from feature f,role_has_features rhf where rhf.feature_id=f.id and rhf.role_id= ( select id from role where role_code='CLIENT');

		return listOfFeatures;
	}

	/**
	 * This function loops through all the feature codes available for Client
	 * role and returns teh same.
	 * 
	 * @return
	 */
	public List<String> getTraderFeatureCodes(String roleId) {
		List<String> listOfFeatures = null;
		
		// Following query can be directly written in featureDaoImpl - no need to create a separate role_daoimpl/role_has_user_daoimpl
		// select f.feature_code from feature f,role_has_features rhf where rhf.feature_id=f.id and rhf.role_id= ?
		return listOfFeatures;
	}
}
