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

import com.ots.common.ClientBean;
import com.ots.common.UserBean;
import com.ots.rowmapper.ClientRowMapper;
import com.ots.rowmapper.UserRowMapper;

/**
 * @author kanchan
 *
 */
public class ClientDaoImpl {

		public static final String SELECT_CLIENT_BY_CLIENT_ID = "SELECT * FROM clients WHERE client_id=?";

	 	public static final String QUERY_INSERT_TASK = "INSERT INTO client(client_id) VALUES (?)";

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
			try {
				adminJdbcConnectionTemplate.getDataSource().getConnection().setAutoCommit(false); // doesnt work! -set it in datasource definition in ots-servlet.xml
			//	adminJdbcConnectionTemplate.getDataSource().getConnection().commit();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			if (/* CollectionUtils.isNotEmpty( */clientBean != null && clientBean.size() != 0) {
				return clientBean.get(0);
			} else {
				return null;
			}
		}
 


}


//placeOrder.html
// insert orderDao
// select * from order orderid
