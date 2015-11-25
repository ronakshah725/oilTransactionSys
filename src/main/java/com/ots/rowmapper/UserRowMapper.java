package com.ots.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ots.common.UserBean;

public class UserRowMapper implements RowMapper<UserBean> {

	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserBean user = new UserBean();
		user.setFirstName(rs.getString("first_name"));
		user.setId(rs.getString("id"));
		
		// set all parameters of users row in the bean
		return user;
	}
}
