
/**
 * 
 */
package com.ots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ots.common.OrderSummaryBean;
import com.ots.common.ReportOilBean;
import com.ots.rowmapper.OrderRowMapper;
import com.ots.rowmapper.ReportOilMapper;

/**
 * @author madhuri
 *
 */

@Repository
public class OrderDaoImpl {

	public static final String QUERY_INSERT_TASK = "INSERT INTO orders(id,type,quantity,commission_fees,commission_type,total_amt,oil_adjusted_quantity,date_placed ) VALUES (?,?,?,?,?,?,?,?)";
	public static final String SELECT_ORDER_BY_USER_ID = "select o.id as id,o.type as type, o.quantity as quantity,o.commission_fees as commission_fees,o.commission_type as commission_type,o.total_amt as total_amt,o.oil_adjusted_quantity as oil_adjusted_quantity,o.date_placed as date_placed, o.payment_id as payment_id,isnull(c.client_id) as is_not_cancelled from orders o left join cancels c on o.id=c.order_id and o.id IN (SELECT order_id FROM places where client_id=?) order by date_placed desc";
	public static final String UPDATE_ORDER = "UPDATE orders SET payment_id = ? WHERE id =? and payment_id is not null";
	public static final String REPORT_OIL_QT = "select sum(o.quantity) as sums,isnull(o.payment_id) as payment_avl, (isnull(c.client_id)!=true) as is_cancelled from orders o left join cancels c on o.id=c.order_id group by payment_avl,is_cancelled order by sums asc";

	private JdbcTemplate adminJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);

	}

	/**
	 * Method for fetching all orders for a client in Descending order
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
	 * This method returns Total amount (to_be?) charged for order
	 * 
	 * @param orderIds
	 * @return
	 */
	public Float getTotalAmountByOrderIds(final List<String> orderIds) {

		StringBuilder selectQueries = new StringBuilder();
		for (String orderId : orderIds) {
			if (orderId.trim().length() > 0) {
				if (selectQueries.toString().length() == 0) {
					selectQueries.append("Select sum(total_amt) as total from orders where id in( ?");
				} else {
					selectQueries.append(",?");
				}
			}
		}
		selectQueries.append(") and payment_id is null;");
		System.out.println(selectQueries.toString());
		List<Float> orders = adminJdbcConnectionTemplate.query(selectQueries.toString(), new PreparedStatementSetter() {
			public void setValues(java.sql.PreparedStatement ps) throws SQLException {

				int counter = 1;
				for (String orderId : orderIds) {
					if (orderId.trim().length() != 0) {
						ps.setString(counter, orderId.trim());
						counter++;
					}
				}
			}
		}, new RowMapper<Float>() {
			public Float mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("rs.getdfloat" + rs.getFloat("total"));
				return rs.getFloat("total");
			}

		});
		System.out.println("-->" + orders);
		return orders.get(0);
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
				ps.setFloat(3, orderSummaryBean.getQuantity());
				ps.setFloat(4, orderSummaryBean.getCommissionindollar());
				ps.setString(5, orderSummaryBean.getCommissionType());
				ps.setFloat(6, orderSummaryBean.getAmount());
				ps.setFloat(7, orderSummaryBean.getCommisisioninoil());
				ps.setDate(8, new java.sql.Date(orderSummaryBean.getDate().getTime()));

				return ps.execute();
			}
		});
	}



	public List<ReportOilBean> getReportOilQty() {
		List<ReportOilBean> rbean = adminJdbcConnectionTemplate.query(REPORT_OIL_QT,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {

					}
				}, new ReportOilMapper());
		System.out.println(rbean);
		return rbean;
	}

}