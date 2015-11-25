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

import com.ots.common.UserBean;

/**
 * @author kanchan
 *
 */

@Repository
public class TraderDaoImpl {

	 	public static final String QUERY_INSERT_TRADER = "INSERT INTO trader(trader_id,role_id) VALUES (?,?)";
	 	public static final String SELECT_TRADER_BY_TRADER_ID = "SELECT * FROM trader WHERE trader_id=?";

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
		 * This method inserts and entry 
		 * @param userBean
		 * @return
		 */
	 	public Boolean insertTraderDetails(final UserBean userBean) {

			return adminJdbcConnectionTemplate.execute(QUERY_INSERT_TRADER, new PreparedStatementCallback<Boolean>() {
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, userBean.getId());
					ps.setString(1, userBean.getUserType().name());
					return ps.execute();
				}
			});
		}

}
