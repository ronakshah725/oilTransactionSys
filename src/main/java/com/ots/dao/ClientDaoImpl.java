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

import com.ots.common.ClientBean;
import com.ots.common.OrderSummaryBean;
import com.ots.common.UserBean;
import com.ots.rowmapper.ClientRowMapper;
import com.ots.rowmapper.UserRowMapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.ots.common.ClientBean;
import com.ots.common.UserBean;

/**
 * @author kanchan
 *
 */
@Repository
public class ClientDaoImpl {

	public static final String SELECT_CLIENT_BY_CLIENT_ID = "SELECT * FROM client WHERE client_id=?";

	public static final String INSERT_CLIENT = "INSERT INTO client(client_id) VALUES (?)";

	public static final String UPDATE_ORDER = "UPDATE client SET total_oil_quantity= ?, balance_amount=? WHERE client_id =?";

	private JdbcTemplate adminJdbcConnectionTemplate;
	private JdbcTemplate traderJdbcConnectionTemplate;
	private JdbcTemplate clientJdbcConnectionTemplate;

	@Autowired
	public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
		this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);
		this.traderJdbcConnectionTemplate = new JdbcTemplate(traderDataSource);
		this.clientJdbcConnectionTemplate = new JdbcTemplate(clientDataSource);
	}
	
	public ClientBean getClientDetails(final String clientID) {

		List<ClientBean> clientBean = adminJdbcConnectionTemplate.query(SELECT_CLIENT_BY_CLIENT_ID,
				new PreparedStatementSetter() {
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, clientID);
					}
				}, new ClientRowMapper());
		if ( clientBean != null && clientBean.size() != 0) {
			return clientBean.get(0);
		} else {
			return null;
		}
	}

	/**
	 * This method updates the mentioned parameters for given client.
	 * @param clientId
	 * @param balanceAmount
	 * @param totalOilQuantity
	 * @return
	 */
	public Boolean updateOilAndBalanceOfClient(final String clientId,final float balanceAmount, final float totalOilQuantity ) {

		return adminJdbcConnectionTemplate.execute(UPDATE_ORDER, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setFloat(1, totalOilQuantity);
				ps.setFloat(2, balanceAmount);
				ps.setString(3, clientId);
				return ps.execute();
			}
		});
	}
	
	
	/**
	 * This method inserts an entry into Client table.
	 * @param userBean
	 * @return
	 */
	public Boolean insertClientDetails(final UserBean userBean) {

		return adminJdbcConnectionTemplate.execute(INSERT_CLIENT, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, userBean.getId());
				return ps.execute();
			}
		});
	}

}
 