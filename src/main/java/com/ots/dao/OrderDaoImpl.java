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

import com.ots.common.OrderSummaryBean;
import com.ots.rowmapper.OrderRowMapper;

/**
 * @author madhuri
 *
 */

@Repository
public class OrderDaoImpl {

	public static final String QUERY_INSERT_TASK = "INSERT INTO orders(id,type,quantity,commission_fees,commission_type,total_amt,oil_adjusted_quantity,date_placed ) VALUES (?,?,?,?,?,?,?,?)";
	public static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders where order_id IN (SELECT order_id FROM places where client_id=?)";
	public static final String UPDATE_ORDER = "UPDATE orders SET payment_id = ? WHERE order_id in (?)";

	private JdbcTemplate adminJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);

	}

	/**
	 * Method for fetching details based on userName and password
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public List<OrderSummaryBean> getOrders(final String clientId) {
		List<OrderSummaryBean> orders = adminJdbcConnectionTemplate.query(SELECT_ORDER_BY_USER_ID,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, clientId);
					}
				}, new OrderRowMapper());
		return orders;

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
	
	

	/**
	 * This method updates the payment into Order table.
	 * 
	 * @param orderBean
	 * @return
	 */
	public Boolean createOrder(final OrderSummaryBean orderSummaryBean) {

		return adminJdbcConnectionTemplate.execute(QUERY_INSERT_TASK, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			 
				
				
				ps.setString(1, orderSummaryBean.getOrderId());
				ps.setString(2, orderSummaryBean.getType());
				
				
				return ps.execute();
			}
		});
	}
	
	
	
	

}