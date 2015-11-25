package com.ots.common;

import java.util.Date;

/**
 * Trader bean   
 * @author kanchan
 *
 */
public class TraderBean {

private String roleId;
private String traderId;
/**
 * @return the roleId
 */
public String getRoleId() {
	return roleId;
}
/**
 * @param roleId the roleId to set
 */
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
/**
 * @return the traderId
 */
public String getTraderId() {
	return traderId;
}
/**
 * @param traderId the traderId to set
 */
public void setTraderId(String traderId) {
	this.traderId = traderId;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "TraderBean [roleId=" + roleId + ", traderId=" + traderId + "]";
} 



}
