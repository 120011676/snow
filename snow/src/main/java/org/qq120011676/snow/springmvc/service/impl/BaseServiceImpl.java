package org.qq120011676.snow.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.qq120011676.snow.entity.PageEntity;
import org.qq120011676.snow.springmvc.dao.iface.IBaseDAO;
import org.qq120011676.snow.springmvc.service.iface.IBaseService;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public abstract class BaseServiceImpl<T, S extends IBaseDAO<T>> implements
		IBaseService<T> {

	protected abstract S getBaseDAO();

	@Override
	public int update(String sqlName, Map<String, Object> map) {
		return this.getBaseDAO().update(sqlName, map);
	}

	@Override
	public SqlRowSet queryForRowSet(String sqlName, Map<String, Object> map) {
		return this.getBaseDAO().queryForRowSet(sqlName, map);
	}

	@Override
	public T queryForObject(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper) {
		return this.getBaseDAO().queryForObject(sqlName, map, rowMapper);
	}

	@Override
	public long queryForLong(String sqlName, Map<String, Object> map) {
		return this.getBaseDAO().queryForLong(sqlName, map);
	}

	@Override
	public <E> List<E> queryForList(String sqlName, Map<String, Object> map,
			Class<E> czass) {
		return this.getBaseDAO().queryForList(sqlName, map, czass);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sqlName,
			Map<String, Object> map) {
		return this.getBaseDAO().queryForList(sqlName, map);
	}

	@Override
	public int queryForInt(String sqlName, Map<String, Object> map) {
		return this.getBaseDAO().queryForInt(sqlName, map);
	}

	@Override
	public T query(String sqlName, Map<String, Object> map,
			ResultSetExtractor<T> resultSetExtractor) {
		return this.getBaseDAO().query(sqlName, map, resultSetExtractor);
	}

	@Override
	public List<T> query(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper) {
		return this.getBaseDAO().query(sqlName, map, rowMapper);
	}

	@Override
	public int updateReturnPrimaryKey(String sqlName, String columnName,
			Map<String, Object> map) {
		return this.getBaseDAO().updateReturnPrimaryKey(sqlName, columnName,
				map);
	}

	@Override
	public KeyHolder updateReturnPrimaryKey(String sqlName,
			String[] columnNames, Map<String, Object> map) {
		return this.getBaseDAO().updateReturnPrimaryKey(sqlName, columnNames,
				map);
	}

	@Override
	public PageEntity<T> queryMySqlPage(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper, int nowPage, int onePageRows) {
		return this.getBaseDAO().queryMySqlPage(sqlName, map, rowMapper,
				nowPage, onePageRows);
	}

}
