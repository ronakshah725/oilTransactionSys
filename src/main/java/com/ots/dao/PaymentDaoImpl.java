/**
 * 
 */
package com.ots.dao;

import java.sql.Date;
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

import com.ots.common.ClientBean;
import com.ots.common.PaymentBean;
import com.ots.common.UserBean;
import com.ots.rowmapper.ClientRowMapper;

/**
 * @author madhuri
 *
 */
@Repository
public class PaymentDaoImpl {

	public static final String QUERY_INSERT_TASK = "INSERT INTO payments(payment_id,client_id,trader_id,date_accepted,amount ) VALUES (?,?,?,?,?)";
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
	 * This method inserts an entry into Payment table.
	 * 
	 * @param userBean
	 * @return
	 */
	public Boolean insertPaymentDetails(final PaymentBean paymentBean) {

		return adminJdbcConnectionTemplate.execute(QUERY_INSERT_TASK, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, paymentBean.getPaymentId());
				ps.setString(2, paymentBean.getClientId());
				ps.setString(3, paymentBean.getTraderId());
				ps.setDate(4,   new java.sql.Date(paymentBean.getDateAccepted().getTime()));
				ps.setFloat(5, paymentBean.getAmount());
				return ps.execute();
			}
		});
	}
}
