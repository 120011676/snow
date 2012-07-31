package org.qq120011676.snow.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.qq120011676.snow.entity.SqlEntity;
import org.qq120011676.snow.type.SqlType;
import org.qq120011676.snow.util.SqlUtils;
import org.qq120011676.snow.xml.sql.SqlFileFilter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SqlXmlParse extends SqlUtils {

	public void sqlXmlParse(String filePath) throws Exception {
		File[] files = new File(filePath).listFiles(new SqlFileFilter());
		Map<String, SqlEntity> sqls = null;
		if (files != null && files.length > 0) {
			sqls = new HashMap<String, SqlEntity>();
		}
		for (int i = 0; i < files.length; i++) {
			this.iterator(sqls, DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(files[i]).getDocumentElement());
		}
		super.initSqls(sqls);
	}

	private Map<String, SqlEntity> iterator(Map<String, SqlEntity> sqls,
			Element element) throws Exception {
		NodeList nodelist = element.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if ("sql".equals(node.getNodeName())) {
				String name = ((Element) node).getAttribute("name");
				if (sqls.containsKey(name)) {
					throw new Exception("this sql name '" + name
							+ "' already exists!");
				}
				sqls.put(name, this.getSqlText((Element) node));
			}
		}
		return sqls;
	}

	private SqlEntity getSqlText(Element element) throws Exception {
		SqlEntity sqlEntity = new SqlEntity();
		StringBuilder sql = new StringBuilder(super.sqlFormat(element.getTextContent()));
		String sqlType = element.getAttribute("type");
		if ("sql".equals(sqlType)) {
			sqlEntity.setSqlType(SqlType.SQL);
		} else if ("hql".equals(sqlType)) {
			sqlEntity.setSqlType(SqlType.HQL);
		} else {
			sqlEntity.setSqlType(SqlType.SQL);
		}
		if (element.hasChildNodes()) {
			NodeList nodeList = element.getChildNodes();
			Map<String, String> parameters = new HashMap<String, String>();
			int size = nodeList.getLength();
			for (int i = 0; i < size; i++) {
				Node node = nodeList.item(i);
				if ("parameter".equals(node.getNodeName())) {
					String parameterName = ((Element) node)
							.getAttribute("name");
					String parameterText = super.sqlFormat(node
							.getTextContent().trim());
					int index = sql.indexOf(parameterText);
					if (index == -1) {
						throw new RuntimeException("this sql parameter name '"
								+ parameterName + "' not exists!");
					}
					sql.replace(index, index + parameterText.length(), " ${"
							+ parameterName + "} ");
					if (parameters.containsKey(parameterName)) {
						throw new RuntimeException("this sql parameter name '"
								+ parameterName + "' already exists!");
					}
					parameters.put(parameterName, parameterText);
					sqlEntity.setParameters(parameters);
				}
			}
		}
		sqlEntity.setSql(super.sqlFormat(sql.toString()));
		return sqlEntity;
	}

}
