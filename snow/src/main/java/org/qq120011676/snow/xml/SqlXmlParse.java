package org.qq120011676.snow.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.tree.DefaultText;
import org.qq120011676.snow.entity.SqlEntity;
import org.qq120011676.snow.type.SqlType;
import org.qq120011676.snow.util.SqlUtils;

public class SqlXmlParse extends SqlUtils implements Runnable {

	private Element root;

	@Override
	public void run() {
		this.dom4jParseSql(root);
	}

	public SqlXmlParse(Element root) {
		this.root = root;
	}

	@SuppressWarnings("rawtypes")
	private void dom4jParseSql(Element element) {
		if ("sql".equals(element.getName())) {
			SqlEntity sqlEntity = new SqlEntity();
			List list = element.content();
			StringBuilder sqlStringBuilder = new StringBuilder();
			Map<String, String> mapParameter = new HashMap<String, String>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof DefaultText) {
					sqlStringBuilder.append(((DefaultText) list.get(i))
							.getText());
				} else if (list.get(i) instanceof Element) {
					Element elementParameter = (Element) list.get(i);
					if ("parameter".equals(elementParameter.getName())) {
						String parameterName = elementParameter.attributeValue(
								"name").trim();
						sqlStringBuilder.append("${").append(parameterName)
								.append("}");
						if (mapParameter.containsKey(parameterName)) {
							throw new RuntimeException(
									"this sql parameter name '" + parameterName
											+ "' already exists!");
						}
						mapParameter.put(parameterName,
								elementParameter.getTextTrim());
					}
				}
			}
			sqlEntity.setSql(SqlUtils.sqlFormat(sqlStringBuilder.toString()));
			sqlEntity.setParameters(mapParameter);
			String type = element.attributeValue("type");
			if ("sql".equals(type)) {
				sqlEntity.setSqlType(SqlType.SQL);
			} else if ("hql".equals(type)) {
				sqlEntity.setSqlType(SqlType.HQL);
			} else {
				sqlEntity.setSqlType(SqlType.SQL);
			}
			String name = element.attributeValue("name").trim();
			synchronized (SqlUtils.getSQLMap()) {
				if (SqlUtils.getSQLMap().containsKey(name)) {
					throw new RuntimeException("this sql name '" + name
							+ "' already exists!");
				}
				SqlUtils.getSQLMap().put(name, sqlEntity);
			}
		} else if ("sqls".equals(element.getName())) {
			List elements = element.elements();
			for (Object object : elements) {
				if (object instanceof Element) {
					this.dom4jParseSql((Element) object);
				}
			}
		}
	}
}
