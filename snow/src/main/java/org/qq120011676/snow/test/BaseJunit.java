package org.qq120011676.snow.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.qq120011676.snow.framework.ProjectInit;
import org.qq120011676.snow.util.FileUtils;
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

	private static boolean isfirst = true;

	private static class BaseJunitProjectInit extends ProjectInit {

		public static void init() throws DocumentException,
				InterruptedException {
			File[] files = new File(ClassLoader.getSystemResource("").getPath()
					+ "../classes").listFiles(new SqlFileFilter());
			BaseJunitProjectInit baseJunitProjectInit = new BaseJunitProjectInit();
			baseJunitProjectInit.initConfig(FileUtils
					.filePropertiesReader("config"));
			baseJunitProjectInit.initMessages(FileUtils
					.filePropertiesReader("messages"));
			List<Thread> threads = new ArrayList<Thread>();
			Thread thread = null;
			if (files != null && files.length >= 0) {
				for (File file : files) {
					thread = new Thread(new SqlXmlParse(new SAXReader().read(
							file).getRootElement()));
					threads.add(thread);
					thread.start();
				}
				for (Thread t : threads) {
					t.join();
				}
			}
		}
	}

	@BeforeClass
	public static void before() throws Exception {
		if (isfirst) {
			isfirst = false;
			BaseJunitProjectInit.init();
		}
	}

	@AfterClass
	public static void after() {
	}
}
