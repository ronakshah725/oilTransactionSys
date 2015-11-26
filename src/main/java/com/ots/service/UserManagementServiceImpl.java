package com.ots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.ClientBean;
import com.ots.common.TraderBean;
import com.ots.common.UserBean;
import com.ots.dao.CancelDaoImpl;
import com.ots.dao.ClientDaoImpl;
import com.ots.dao.FeatureDaoImpl;
import com.ots.dao.TraderDaoImpl;
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

	@Autowired
	private ClientDaoImpl clientDao;

	@Autowired
	private TraderDaoImpl traderDao;

	@Autowired
	private FeatureDaoImpl featureDao;

	@Autowired
	private CancelDaoImpl cancelDao;

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
	 * @param email
	 * @return
	 */
	public ClientBean getClientDetails(String id) {
		ClientBean cbean = clientDao.getClientDetails(id);
		if (cbean != null) {
			cbean.setUserBean(userDao.getUserDetailsById(id));
		}
		return cbean;
	}

	/**
	 * This method executes a select query on Trader table by id and returns the
	 * bean as output
	 * 
	 * @param traderID
	 * @return traderBean
	 */

	public TraderBean getTraderDetails(String traderID) {
		TraderBean tbean = traderDao.getTraderDetails(traderID);
		return tbean;

	}

	/**
	 * This function loops through all the feature codes available for Client
	 * role and returns the same.
	 * 
	 * @return
	 */
	public List<String> getClientFeatureCodes(String clientID) {
		List<String> listOfFeatures = featureDao.getClientFeatureCodes(clientID);
		return listOfFeatures;
	}

	/**
	 * This function loops through all the feature codes available for Client
	 * role and returns the same.
	 * 
	 * @return
	 */
	public List<String> getTraderFeatureCodes(String roleID) {
		List<String> listOfFeatures = featureDao.getTraderFeatureCodes(roleID);

		return listOfFeatures;
	}

	/**
	 * This method accepts UserBean and creates corresponding users in database.
	 * 
	 * @param userBean
	 */
	public Boolean insertUser(UserBean userBean) {

		try {
			userDao.insertUserDetails(userBean);
		} catch (MySQLIntegrityConstraintViolationException mse) {
			return null;
		}
		UserBean bean = userDao.getUserDetails(userBean.getEmailId());
		System.out.println(bean);
		bean.setUserType(userBean.getUserType());
		if (bean != null) {
			switch (userBean.getUserType()) {
			case CLIENT:
				return clientDao.insertClientDetails(bean);
			case TRADER:
			case ADMIN:
				return traderDao.insertTraderDetails(bean);
			}
		}
		return null;
	}

	/**
	 * This method accepts search criteria and performs an OR search on users
	 * table.
	 * 
	 * @param userBean
	 * @return
	 */
	public List<UserBean> searchUser(final UserBean userBean) {
		return userDao.searchUser(userBean);
	}

	public boolean insertIntoCancel(UserBean ub, ClientBean cb, String orderID)
			throws MySQLIntegrityConstraintViolationException {
		return cancelDao.insertIntoCancel(ub.getId(), cb.getClientId(), orderID);
	}
	
	
/**
 * this method updates the account balance of the user.
 * @param clientId
 * @param balanceAmount
 * @param totalOilQuantity
 * @return
 */
	public Boolean updateOilAndBalanceOfClient(final String clientId,final float balanceAmount, final float totalOilQuantity ) {
	return clientDao.updateOilAndBalanceOfClient(clientId, balanceAmount, totalOilQuantity);
	}
}
