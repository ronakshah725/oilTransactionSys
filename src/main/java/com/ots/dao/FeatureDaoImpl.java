/**
 * 
 */
package com.ots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * @author kanchan
 *
 */

@Repository
public class FeatureDaoImpl {

	 	public static final String SELECT_FEATURE_BY_CLIENT_ID = "SELECT f.feature_code FROM feature f,role_has_features rhf where rhf.feature_id=f.id and rhf.role_id= ( select id from role where role_code='CLIENT')";

	 	public static final String SELECT_FEATURE_BY_TRADER_ID = "select f.feature_code from feature f,role_has_features rhf where rhf.feature_id=f.id and rhf.role_id= ?";

		private JdbcTemplate adminJdbcConnectionTemplate;
		private JdbcTemplate traderJdbcConnectionTemplate;
		private JdbcTemplate clientJdbcConnectionTemplate;

		@Autowired
		public void setDataSource(DataSource adminDataSource, DataSource traderDataSource, DataSource clientDataSource) {
			this.adminJdbcConnectionTemplate = new JdbcTemplate(adminDataSource);
			this.traderJdbcConnectionTemplate = new JdbcTemplate(traderDataSource);
			this.clientJdbcConnectionTemplate = new JdbcTemplate(clientDataSource);
		}
		
		
		public List<String> getClientFeatureCodes(final String clientID) {

			List<String> feature = adminJdbcConnectionTemplate.query(SELECT_FEATURE_BY_CLIENT_ID,
					new PreparedStatementSetter() {
						public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						}
					} ,new RowMapper<String>() {

						  public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						        return rs.getString(1);
						  }

						});

			
			
			if ( feature != null && feature.size()  != 0) {
				return feature;
			} else {
				return null;
			}
		}
		
		
		public List<String> getTraderFeatureCodes(final String roleId) {

			List<String> feature = adminJdbcConnectionTemplate.query(SELECT_FEATURE_BY_TRADER_ID,
					new PreparedStatementSetter() {
						public void setValues(java.sql.PreparedStatement ps) throws SQLException {
							ps.setString(1, roleId);
						}
					} ,new RowMapper<String>() {

						  public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						        return rs.getString(1);
						  }

						});

			
			
			if ( feature != null && feature.size()  != 0) {
				return feature;
			} else {
				return null;
			}
		}
		
		
		
 


}
