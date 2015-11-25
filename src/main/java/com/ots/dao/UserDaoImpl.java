/**
 * 
 */
package com.ots.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

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

	public static final String QUERY_INSERT_TASK = "INSERT INTO users(id,first_name,last_name) VALUES (?,?,?)";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserBean getUserDetails(final String userName, final String password) {

		List<UserBean> userBean = jdbcTemplate.query(SELECT_USER_BY_CREDS,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, userName);
						ps.setString(2, password);
					}
				}, new UserRowMapper());
		
		System.out.println(userBean);
		if (/*CollectionUtils.isNotEmpty(*/userBean!=null && userBean.size()!=0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}
}
