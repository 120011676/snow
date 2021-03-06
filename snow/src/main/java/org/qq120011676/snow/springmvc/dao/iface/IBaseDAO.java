/*
 * Copyright (C) 2012 四川新东网技术科技有限公司., All Rights Reserved.
 */
package org.qq120011676.snow.springmvc.dao.iface;

import java.util.List;
import java.util.Map;

import org.qq120011676.snow.entity.PageEntity;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * @ClassName: IBaseDAO
 * @author 李飞龙
 */
public interface IBaseDAO<T> {

	int update(String sqlName, Map<String, Object> map);

	SqlRowSet queryForRowSet(String sqlName, Map<String, Object> map);

	<A extends T> A queryForObject(String sqlName, Map<String, Object> map,
			RowMapper<A> rowMappr);

	long queryForLong(String sqlName, Map<String, Object> map);

	<A extends T> List<A> queryForList(String sqlName, Map<String, Object> map,
			Class<A> czass);

	List<Map<String, Object>> queryForList(String sqlName,
			Map<String, Object> map);

	int queryForInt(String sqlName, Map<String, Object> map);

	<A extends T> A query(String sqlName, Map<String, Object> map,
			ResultSetExtractor<A> resultSetExtractor);

	<A extends T> List<A> query(String sqlName, Map<String, Object> map,
			RowMapper<A> rowMapper);

	int updateReturnPrimaryKey(String sqlName, String columnName,
			Map<String, Object> map);

	KeyHolder updateReturnPrimaryKey(String sqlName, String[] columnNames,
			Map<String, Object> map);

	public <A extends T> PageEntity<A> queryMySqlPage(String sqlName,
			Map<String, Object> map, RowMapper<A> rowMapper, int nowPage,
			int onePageRows);
}
