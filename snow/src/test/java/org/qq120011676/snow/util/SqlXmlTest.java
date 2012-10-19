package org.qq120011676.snow.util;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultText;
import org.junit.Ignore;
import org.junit.Test;
import org.qq120011676.snow.base.BaseJunit;
import org.qq120011676.snow.entity.SqlEntity;
import org.qq120011676.snow.properties.ProjectProperties;
import org.qq120011676.snow.type.SqlType;
import org.qq120011676.snow.util.SqlUtils;
import org.qq120011676.snow.xml.SqlXmlParse;
import org.qq120011676.snow.xml.sql.SqlFileFilter;

public class SqlXmlTest extends BaseJunit {

	@Ignore
	@Test
	public void test() {
		// SqlXmlParse s = new SqlXmlParse();
		// try {
		// s.sqlXmlParse("E:\\test");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("c", "");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("phoneCall", "%" + "" + "%");
//		System.out.println(SqlUtils.getSql("queryTicket", map));

		// StringBuilder as= new StringBuilder("0123");
		// String aa ="12";
		// System.out.println(as.indexOf(aa));
		// as.replace(as.indexOf(aa), as.indexOf(aa)+aa.length()-1, "abc");
		// System.out.println(as);
	}

//	@Test
//	public void dom4j() throws DocumentException {
//		File[] files = new File("E:\\test").listFiles(new SqlFileFilter());
//		SAXReader saxReader = new SAXReader();
//		Document document = saxReader.read(files[0]);
//		Element root = document.getRootElement();
//		if ("sqls".equals(root.getName())) {
//			List<Element> elements = root.elements();
//			for (Element element : elements) {
//				if ("sql".equals(element.getName())) {
//					List<Object> list = element.content();
//					for (int i = 0; i < list.size(); i++) {
//						if (list.get(i) instanceof DefaultText) {
//							System.out.println(((DefaultText) list.get(i))
//									.getText());
//							System.out.println("======");
//						} else if (list.get(i) instanceof Element) {
//							Element element2 = (Element) list.get(i);
//							System.out.println(element2);
//						}
//					}
//				}
//			}
//		}
//	}
//
//	@Test
//	public void sql() throws DocumentException {
//		 File[] files = new File("E:\\test").listFiles(new SqlFileFilter());
//		 SAXReader saxReader = new SAXReader();
//		 Document document = saxReader.read(files[0]);
//		 Element root = document.getRootElement();
//		 this.dom4j(root);
//
//		System.out.println(SqlUtils.getSql("queryCategoryDetails"));
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("detailsName", "");
//		System.out.println(SqlUtils.getSql("queryCategoryDetails", map));
//	}
//
//	public static void main(String[] args) {
//		File[] files = new File("E:\\test").listFiles(new SqlFileFilter());
//		System.out.println(files[files.length-1]);
//		Thread thread = null;
//		System.out.println(new Date().getTime());
//		if (files != null && files.length >= 0) {
//			for (File file : files) {
//				try {
//					thread = new Thread(new SqlXmlParse(new SAXReader().read(
//							file).getRootElement()));
//					thread.start();
//					thread.join();
//				} catch (DocumentException e) {
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		System.out.println(new Date().getTime());
//		System.out.println(SqlUtils.getSql("getLoginUser"));
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("detailsName", "");
//		System.out.println(SqlUtils.getSql("queryCategoryDetails", map));
//	}
//
//	public void dom4j(Element element) {
//		if ("sql".equals(element.getName())) {
//			SqlEntity sqlEntity = new SqlEntity();
//			List list = element.content();
//			StringBuilder sqlStringBuilder = new StringBuilder();
//			Map<String, String> mapParameter = new HashMap<String, String>();
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i) instanceof DefaultText) {
//					sqlStringBuilder.append(((DefaultText) list.get(i))
//							.getText());
//				} else if (list.get(i) instanceof Element) {
//					Element elementParameter = (Element) list.get(i);
//					if ("parameter".equals(elementParameter.getName())) {
//						String parameterName = elementParameter.attributeValue(
//								"name").trim();
//						sqlStringBuilder.append("${").append(parameterName)
//								.append("}");
//						if (mapParameter.containsKey(parameterName)) {
//							throw new RuntimeException(
//									"this sql parameter name '" + parameterName
//											+ "' already exists!");
//						}
//						mapParameter.put(parameterName,
//								elementParameter.getTextTrim());
//					}
//				}
//				sqlStringBuilder.append(" ");
//			}
//			sqlEntity.setSql(SqlUtils.sqlFormat(sqlStringBuilder.toString()));
//			sqlEntity.setParameters(mapParameter);
//			String type = element.attributeValue("type");
//			if ("sql".equals(type)) {
//				sqlEntity.setSqlType(SqlType.SQL);
//			} else if ("hql".equals(type)) {
//				sqlEntity.setSqlType(SqlType.HQL);
//			} else {
//				sqlEntity.setSqlType(SqlType.SQL);
//			}
//			String name = element.attributeValue("name").trim();
//			if (SqlUtils.getSQLMap().containsKey(name)) {
//				throw new RuntimeException("this sql name '" + name
//						+ "' already exists!");
//			}
//			SqlUtils.getSQLMap().put(name, sqlEntity);
//		} else if ("sqls".equals(element.getName())) {
//			List elements = element.elements();
//			for (Object object : elements) {
//				if (object instanceof Element) {
//					this.dom4j((Element) object);
//				}
//			}
//		}
//	}
}
