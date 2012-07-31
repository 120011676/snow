package org.qq120011676.snow.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.qq120011676.snow.properties.ProjectProperties;
import org.qq120011676.snow.util.SqlUtils;
import org.qq120011676.snow.xml.SqlXmlParse;

public class SqlXmlTest {

	@Test
	public void test() {
		SqlXmlParse s = new SqlXmlParse();
		try {
			s.sqlXmlParse("E:/workspace/AutoShowManager/build/classes");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("c", "");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phoneCall", "%" + "" + "%");
		System.out.println(SqlUtils.getSql("queryTicket", map));

		// StringBuilder as= new StringBuilder("0123");
		// String aa ="12";
		// System.out.println(as.indexOf(aa));
		// as.replace(as.indexOf(aa), as.indexOf(aa)+aa.length()-1, "abc");
		// System.out.println(as);
	}

}
