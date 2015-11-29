package com.ots.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ots.common.ReportOilBean;

public class ReportOilMapper implements RowMapper<ReportOilBean> {

	public ReportOilBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		ReportOilBean report = new ReportOilBean();
		report.setSums(rs.getFloat("sums"));
		report.setSums(rs.getFloat("payment_avl"));
		report.setSums(rs.getFloat("is_cancelled"));

		return report;
	}
}
