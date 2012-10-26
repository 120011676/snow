package org.qq120011676.snow.springmvc.service.iface;

import java.util.List;
import java.util.Map;

import org.qq120011676.snow.entity.PageEntity;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IBaseService<T> {

	/**
	 * 更新方法
	 * 
	 * @param sqlName
	 *            sql名字
	 * @param map
	 *            sql参数
	 * @return 受影响的行数
	 */
	int update(String sqlName, Map<String, Object> map);

	SqlRowSet queryForRowSet(String sqlName, Map<String, Object> map);

	T queryForObject(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper);

	long queryForLong(String sqlName, Map<String, Object> map);

	<E> List<E> queryForList(String sqlName, Map<String, Object> map,
			Class<E> czass);

	List<Map<String, Object>> queryForList(String sqlName,
			Map<String, Object> map);

	int queryForInt(String sqlName, Map<String, Object> map);

	T query(String sqlName, Map<String, Object> map,
			ResultSetExtractor<T> resultSetExtractor);

	List<T> query(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper);

	int updateReturnPrimaryKey(String sqlName, String columnName,
			Map<String, Object> map);

	KeyHolder updateReturnPrimaryKey(String sqlName, String[] columnNames,
			Map<String, Object> map);

	PageEntity<T> queryMySqlPage(String sqlName, Map<String, Object> map,
			RowMapper<T> rowMapper, int nowPage, int onePageRows);
}
