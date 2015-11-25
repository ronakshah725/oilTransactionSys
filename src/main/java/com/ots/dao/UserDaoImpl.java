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

	private JdbcTemplate adminJdbcConnectionTemplate;
	private JdbcTemplate traderJdbcConnectionTemplate;
	private JdbcTemplate clientJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);
		this.traderJdbcConnectionTemplate = new JdbcTemplate(traderDataSource);
		this.clientJdbcConnectionTemplate = new JdbcTemplate(clientDataSource);
	}

	public UserBean getUserDetails(final String userName, final String password) {

		List<UserBean> userBean = adminJdbcConnectionTemplate.query(SELECT_USER_BY_CREDS,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, userName);
						ps.setString(2, password);
					}
				}, new UserRowMapper());
		try {
			adminJdbcConnectionTemplate.getDataSource().getConnection().setAutoCommit(false); // doesnt work! -set it in datasource definition in ots-servlet.xml
		//	adminJdbcConnectionTemplate.getDataSource().getConnection().commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		System.out.println(userBean);
		if (/* CollectionUtils.isNotEmpty( */userBean != null && userBean.size() != 0) {
			return userBean.get(0);
		} else {
			return null;
		}
	}
}
