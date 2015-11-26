package com.ots.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ots.common.TraderBean;;

public class TraderRowMapper implements RowMapper<TraderBean> {

	public TraderBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		TraderBean trader = new TraderBean();
		trader.setTraderId(rs.getString("trader_id"));
		trader.setRoleId(rs.getString("role_id"));
		
		// set all parameters of users row in the bean
		return trader;
	}
}
