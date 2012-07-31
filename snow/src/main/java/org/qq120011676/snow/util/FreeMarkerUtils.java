package org.qq120011676.snow.util;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;

public class FreeMarkerUtils {

	private static Configuration CONFIGURATION = new Configuration();

	protected void init(String pathname) throws IOException {
		CONFIGURATION.setDirectoryForTemplateLoading(new File(pathname));
		CONFIGURATION.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		CONFIGURATION.setEncoding(Locale.CHINA, "UTF-8");
	}

	public static Configuration getconfiguration() {
		return CONFIGURATION;
	}
}
