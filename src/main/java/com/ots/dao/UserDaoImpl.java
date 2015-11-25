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

	public static final String INSERT_USER = "INSERT INTO users(id,first_name,last_name,apt_no,street,city,state,zip_code,phone_no,cell_no,email,password,company_id)"
			+ " VALUES (uuid(),?,?,?,?,?,?,?,?,?,?,aes_encrypt(?,'password'),'4fb19e50-9314-11e5-b673-5820b1762284');";

	private JdbcTemplate adminJdbcConnectionTemplate;
	private JdbcTemplate traderJdbcConnectionTemplate;
	private JdbcTemplate clientJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);
		this.traderJdbcConnectionTemplate = new JdbcTemplate(traderDataSource);
		this.clientJdbcConnectionTemplate = new JdbcTemplate(clientDataSource);
	}

	/**
	 * Method for fetching details based on userName and password
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

	public UserBean getUserDetails(final String userName) {
		List<UserBean> userBean = adminJdbcConnectionTemplate.query(SELECT_USER_BY_EMAIL,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, userName);
					}
				}, new UserRowMapper());

		System.out.println(userBean);
		if (userBean != null && userBean.size() != 0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}


	
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
