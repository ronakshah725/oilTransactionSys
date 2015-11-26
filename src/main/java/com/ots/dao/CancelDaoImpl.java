/**
 * 
 */
package com.ots.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ots.common.OrderSummaryBean;
import com.ots.common.UserBean;

/**
 * @author madhuri
 *
 */

@Repository
public class CancelDaoImpl {

	public static final String QUERY_INSERT_TASK = "INSERT INTO cancels(user_id,client_id,order_id ) VALUES (?,?,?)";


	private JdbcTemplate adminJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);

	}
	
	/**
	 * This method inserts entry into user table.
	 * 
	 * @param userBean
	 * @return
	 * @throws MySQLIntegrityConstraintViolationException
	 */
	public Boolean insertIntoCancel(final String userID ,final String clientID, final String orderID) throws MySQLIntegrityConstraintViolationException {

		return adminJdbcConnectionTemplate.execute(QUERY_INSERT_TASK, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, userID.trim() );
				ps.setString(2, clientID.trim());
				ps.setString(3, orderID.trim());

				return ps.execute();
			}
		});

	}

}