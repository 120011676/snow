package org.qq120011676.snow.springmvc.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringIOCUtils {

	public static Object getBean(ServletContext servletContext, String beanId) {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		return applicationContext.getBean(beanId);
	}

	public static <T> T getBean(ServletContext servletContext, Class<T> t) {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		return applicationContext.getBean(t);
	}
}