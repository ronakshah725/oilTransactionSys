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

import com.ots.common.OrderSummaryBean;

/**
 * @author madhuri
 *
 */

@Repository
public class OrderDaoImpl {

	public static final String QUERY_INSERT_TASK = "INSERT INTO orders(id,type,trans_fee,quantity,commission_fees,commission_type,total_amt,oil_adjusted_quantity,date_placed ) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders where order_id IN (SELECT order_id FROM places where client_id=?)";
	public static final String UPDATE_ORDER = "UPDATE orders SET payment_id = ? WHERE order_id in (?)";

	private JdbcTemplate adminJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);

	}

	/**
	 * This method updates the payment into Order table.
	 * 
	 * @param orderBean
	 * @return
	 */
	public Boolean updateOrderDetails(final OrderSummaryBean orderSummaryBean) {

		return adminJdbcConnectionTemplate.execute(UPDATE_ORDER, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, orderSummaryBean.getPaymentId());
				ps.setString(2, orderSummaryBean.getOrderId());
				return ps.execute();
			}
		});
	}

}
