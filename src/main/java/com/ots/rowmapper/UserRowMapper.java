package com.ots.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ots.common.UserBean;

/**
 * RowMapper class for UserBean.java
 * @author kanchan
 *
 */
public class UserRowMapper implements RowMapper<UserBean> {

	/**
	 * This method maps Resultset to the UserBean
	 */
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserBean user = new UserBean();
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmailId(rs.getString("email"));
		user.setApartmentNumber(rs.getString("apt_no"));
		user.setStreet(rs.getString("street"));
		user.setCity(rs.getString("city"));
		user.setPhoneNumber(rs.getInt("phone_no"));
		user.setZipcode(rs.getInt("zip_code"));
		user.setCellPhoneNumber(rs.getInt("cell_no"));
		user.setId(rs.getString("id"));
		user.setEmailId(rs.getString("email"));
		user.setCompanyId(rs.getString("company_id"));
		return user;
	}
}
