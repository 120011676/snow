package org.qq120011676.snow.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.qq120011676.snow.entity.PageEntity;
import org.qq120011676.snow.springmvc.dao.iface.IBaseDAO;
import org.qq120011676.snow.util.SqlUtils;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class BaseDAOImpl<T> extends NamedParameterJdbcDaoSupport implements
		IBaseDAO<T> {

	@Resource(name = "dataSource")
	public void ds(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public int update(String sqlName, Map<String, Object> map) {
		return super.getNamedParameterJdbcTemplate().update(
				SqlUtils.getSql(sqlName, map), map);
	}

	@Override
	public SqlRowSet queryForRowSet(String sqlName, Map<String, Object> map) {
		return super.getNamedParameterJdbcTemplate().queryForRowSet(
				SqlUtils.getSql(sqlName, map), map);
	}

	@Override
	public T queryForObject(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper) {
		return super.getNamedParameterJdbcTemplate().queryForObject(
				SqlUtils.getSql(sqlName, map), map, rowMapper);
	}

	@Override
	public long queryForLong(String sqlName, Map<String, Object> map) {
		return super.getNamedParameterJdbcTemplate().queryForLong(
				SqlUtils.getSql(sqlName, map), map);
	}

	@Override
	public <E> List<E> queryForList(String sqlName, Map<String, Object> map,
			Class<E> czass) {
		return super.getNamedParameterJdbcTemplate().queryForList(
				SqlUtils.getSql(sqlName, map), map, czass);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sqlName,
			Map<String, Object> map) {
		return super.getNamedParameterJdbcTemplate().queryForList(
				SqlUtils.getSql(sqlName, map), map);
	}

	@Override
	public int queryForInt(String sqlName, Map<String, Object> map) {
		return super.getNamedParameterJdbcTemplate().queryForInt(
				SqlUtils.getSql(sqlName, map), map);
	}

	@Override
	public T query(String sqlName, Map<String, Object> map,
			ResultSetExtractor<T> resultSetExtractor) {
		return super.getNamedParameterJdbcTemplate().query(
				SqlUtils.getSql(sqlName, map), map, resultSetExtractor);
	}

	@Override
	public List<T> query(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper) {
		return super.getNamedParameterJdbcTemplate().query(
				SqlUtils.getSql(sqlName, map), map, rowMapper);
	}

	@Override
	public int updateReturnPrimaryKey(String sqlName, String columnName,
			Map<String, Object> map) {
		return this
				.updateReturnPrimaryKey(sqlName, new String[] { columnName },
						map).getKey().intValue();
	}

	@Override
	public KeyHolder updateReturnPrimaryKey(String sqlName,
			String[] columnNames, Map<String, Object> map) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		super.getNamedParameterJdbcTemplate().update(
				SqlUtils.getSql(sqlName, map), new MapSqlParameterSource(map),
				keyHolder, columnNames);
		return keyHolder;
	}

	@Override
	public PageEntity queryMySqlPage(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper, int nowPage, int onePageRows) {
		String sql = SqlUtils.getSql(sqlName, map);
		return this.queryPage(sql, this.getMysqlPageSql(sql), map, rowMapper,
				nowPage, onePageRows);
	}

	private PageEntity queryPage(String sql, String sqlPage,
			Map<String, Object> map, RowMapper<T> rowMapper, int nowPage,
			int onePageRows) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(1) from (");
		stringBuilder.append(sql);
		stringBuilder.append(") pageCount");
		int count = super.getNamedParameterJdbcTemplate().queryForInt(
				stringBuilder.toString(), map);
		PageEntity page = new PageEntity();
		if (count > 0) {
			page.setMaxCount(count);
			page.setMaxPage(count % onePageRows == 0 ? count / onePageRows
					: count / onePageRows + 1);
			map.put("nowPage", nowPage * onePageRows);
			map.put("onePageRows", onePageRows);
			page.setResults(super.getNamedParameterJdbcTemplate().query(
					sqlPage, map, rowMapper));
			page.setNowPage(nowPage);
			page.setOnePageRows(onePageRows);
		}
		return page;
	}

	private String getMysqlPageSql(String sql) {
		return new StringBuilder(sql).append(" limit :nowPage,:onePageRows")
				.toString();
	}
}