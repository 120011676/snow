package org.qq120011676.snow.framework;

import java.io.IOException;
import java.util.Map;

import org.qq120011676.snow.properties.ProjectProperties;
import org.qq120011676.snow.util.FreeMarkerUtils;
import org.qq120011676.snow.util.ProjectUtils;

public class ProjectInit {

	private class ProjectUtilInit extends ProjectUtils {
		protected void initProjectRealPath(String projectRealPath) {
			super.initProjectRealPath(projectRealPath);
		}
	}

	protected void initProjectRealPath(String projectRealPath) {
		new ProjectUtilInit().initProjectRealPath(projectRealPath);
	}

	private class ProjectPropertiesInit extends ProjectProperties {
		protected void initMessages(Map<String, String> map) {
			super.initMessages(map);
		}

		protected void initConfig(Map<String, String> map) {
			super.initConfig(map);
		}
	}

	protected void initMessages(Map<String, String> map) {
		new ProjectPropertiesInit().initMessages(map);
	}

	protected void initConfig(Map<String, String> map) {
		new ProjectPropertiesInit().initConfig(map);
	}

	private class FreeMarkerUtilsInit extends FreeMarkerUtils {
		protected void initFreemarker(String pathname) throws IOException {
			super.init(pathname);
		}
	}

	protected void initFreemarker(String pathname) throws IOException {
		new FreeMarkerUtilsInit().initFreemarker(pathname);
	}
}
