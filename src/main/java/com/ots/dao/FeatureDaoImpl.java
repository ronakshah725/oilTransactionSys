/**
 * 
 */
package com.ots.dao;

/**
 * @author kanchan
 *
 */
public class FeatureDaoImpl {

	 	public static final String SELECT_FEATURE_BY_ID = "SELECT f.feature_code FROM feature f,role_has_features rhf where rhf.feature_id=f.id and rhf.role_id= ( select id from role where role_code='CLIENT')";


 


}
