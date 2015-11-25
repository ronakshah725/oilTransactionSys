package com.ots.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ots.common.ClientBean;
import com.ots.common.UserBean;


public class ClientRowMapper implements RowMapper<ClientBean> {



	public ClientBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientBean client = new ClientBean();
		client.setClientId(rs.getString("client_id"));
		
		// set all parameters of users row in the bean
		return client;
	}

}
