package org.qq120011676.snow.entity;

import java.util.Map;

import org.qq120011676.snow.type.SqlType;

public class SqlEntity {

	private String sql;

	private SqlType sqlType;

	private Map<String, String> parameters;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public SqlType getSqlType() {
		return sqlType;
	}

	public void setSqlType(SqlType sqlType) {
		this.sqlType = sqlType;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

}
