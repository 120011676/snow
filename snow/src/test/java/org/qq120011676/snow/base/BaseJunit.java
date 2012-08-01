package org.qq120011676.snow.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.qq120011676.snow.xml.SqlXmlParse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BaseJunit {

	@Before
	public void start() throws Exception {
		SqlXmlParse sqlXmlParse = new SqlXmlParse();
		sqlXmlParse.sqlXmlParse(ClassLoader.getSystemResource("").getPath());
	}

	@After
	public void after() {
	}
}
