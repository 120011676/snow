package org.qq120011676.snow.base;

import java.io.File;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.qq120011676.snow.xml.SqlXmlParse;
import org.qq120011676.snow.xml.sql.SqlFileFilter;
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
		File[] files = new File("E:\\test").listFiles(new SqlFileFilter());
		Thread thread = null;
		if (files != null && files.length >= 0) {
			for (File file : files) {
				try {
					thread = new Thread(new SqlXmlParse(new SAXReader().read(
							file).getRootElement()));
					thread.start();
					thread.join();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@After
	public void after() {
	}
}
