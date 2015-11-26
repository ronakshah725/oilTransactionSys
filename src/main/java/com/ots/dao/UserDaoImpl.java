/**
 * 
 */
package com.ots.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.UserBean;
import com.ots.rowmapper.UserRowMapper;

/**
 * @author kanchan
 *
 */
@Repository
public class UserDaoImpl {

	public static final String SELECT_USER_BY_CREDS = "SELECT * FROM users WHERE email= ? and aes_decrypt(password,'password')=?";

	public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email= ? ";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id= ? ";
	
	public static final String INSERT_USER = "INSERT INTO users(id,first_name,last_name,apt_no,street,city,state,zip_code,phone_no,cell_no,email,password,company_id)"
			+ " VALUES (uuid(),?,?,?,?,?,?,?,?,?,?,aes_encrypt(?,'password'),'4fb19e50-9314-11e5-b673-5820b1762284');";

	public static final String SEARCH_USER = "SELECT * FROM users WHERE (last_name=? OR apt_no=? OR street=? OR city=? OR zip_code=? OR phone_no=? OR cell_no=? OR email= ?) and id in(select client_id from client) order by email asc";

	private JdbcTemplate adminJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);
	}

	/**
	 * Method for fetching details based on userName and password
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserBean getUserDetails(final String userName, final String password) {
		List<UserBean> userBean = adminJdbcConnectionTemplate.query(SELECT_USER_BY_CREDS,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, userName);
						ps.setString(2, password);
					}
				}, new UserRowMapper());

		System.out.println(userBean);
		if (userBean != null && userBean.size() != 0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}

	/**
	 * This method searches user based on OR search.
	 * 
	 * @param userBean
	 * @return
	 */
	public List<UserBean> searchUser(final UserBean userBean) {
		List<UserBean> userBeans = adminJdbcConnectionTemplate.query(SEARCH_USER, new PreparedStatementSetter() {
			public void setValues(java.sql.PreparedStatement ps) throws SQLException {
				ps.setString(1, userBean.getLastName()==null|| userBean.getLastName().length()==0?"__":userBean.getLastName());
				ps.setString(2, userBean.getApartmentNumber()==null|| userBean.getApartmentNumber().length()==0?"__":userBean.getApartmentNumber());
				ps.setString(3, userBean.getStreet()==null|| userBean.getStreet().length()==0?"___":userBean.getStreet());
				ps.setString(4, userBean.getCity()==null || userBean.getCity().length()==0?"___":userBean.getCity());
				ps.setInt(5, userBean.getZipcode()==null ? -999:userBean.getZipcode());
				ps.setInt(6, userBean.getPhoneNumber()==null?-999:userBean.getPhoneNumber());
				ps.setInt(7, userBean.getCellPhoneNumber()==null?-999:userBean.getCellPhoneNumber());
				ps.setString(8, userBean.getEmailId()==null || userBean.getEmailId().length()==0?"___":userBean.getEmailId());
			}
		}, new UserRowMapper());

		System.out.println(userBeans);
		return userBeans;
	}

	/**
	 * This method does lookup based on email
	 * 
	 * @param email
	 * @return
	 */
	public UserBean getUserDetails(final String email) {
		List<UserBean> userBean = adminJdbcConnectionTemplate.query(SELECT_USER_BY_EMAIL,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, email);
					}
				}, new UserRowMapper());

		System.out.println(userBean);
		if (userBean != null && userBean.size() != 0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}

	
	public UserBean getUserDetailsById(final String id) {
		List<UserBean> userBean = adminJdbcConnectionTemplate.query(SELECT_USER_BY_ID,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, id);
					}
				}, new UserRowMapper());

		System.out.println(userBean);
		if (userBean != null && userBean.size() != 0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}
	/**
	 * This method inserts entry into user table.
	 * 
	 * @param userBean
	 * @return
	 * @throws MySQLIntegrityConstraintViolationException
	 */
	public Boolean insertUserDetails(final UserBean userBean) throws MySQLIntegrityConstraintViolationException {

		return adminJdbcConnectionTemplate.execute(INSERT_USER, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, userBean.getFirstName());
				ps.setString(2, userBean.getLastName());
				ps.setString(3, userBean.getApartmentNumber());
				ps.setString(4, userBean.getStreet());
				ps.setString(5, userBean.getCity());
				ps.setString(6, userBean.getState());
				ps.setInt(7, userBean.getZipcode());
				ps.setInt(8, userBean.getPhoneNumber());
				ps.setInt(9, userBean.getCellPhoneNumber());
				ps.setString(10, userBean.getEmailId());
				ps.setString(11, userBean.getPassword());
				return ps.execute();
			}
		});

	}
}
