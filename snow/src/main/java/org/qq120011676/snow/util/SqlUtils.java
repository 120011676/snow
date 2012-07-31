package org.qq120011676.snow.util;

import java.util.Map;

import org.qq120011676.snow.entity.SqlEntity;
import org.qq120011676.snow.properties.ProjectProperties;

public class SqlUtils {

	private static Map<String, SqlEntity> SQLS;

	protected void initSqls(Map<String, SqlEntity> sqls) {
		SQLS = sqls;
	}

	private static SqlEntity getSqlEntity(String name) {
		return SQLS.get(name);
	}

	public static String getSql(String name) {
		return getSql(name, null);
	}

	public static String getSql(String name, Map<String, Object> map) {
		SqlEntity sqlEntity = getSqlEntity(name);
		if (sqlEntity == null) {
			throw new RuntimeException("this sql name ‘" + name + "' not exist");
		}
		String sql = sqlEntity.getSql();
		if (map != null && sqlEntity.getParameters() != null) {
			for (String parameterName : map.keySet()) {
				String parameterText = sqlEntity.getParameters().get(
						parameterName);
				sql = ProjectProperties.setMessagesParameter(sql,
						parameterName, parameterText);
			}
		}
		return sqlFormat(sql.replaceAll("\\$\\{[ ]*\\w*[ ]*\\}", ""));
	}

	public static String sqlFormat(String sql) {
		return sql.replaceAll("\n|\t", " ").replaceAll(" +", " ").trim();
	}
}
