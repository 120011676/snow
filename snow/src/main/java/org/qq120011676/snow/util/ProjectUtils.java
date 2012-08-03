package org.qq120011676.snow.util;

public class ProjectUtils {

	private static String PROJECT_REAL_PATH;

	private static String PROJECT_CLASS_PATH;

	protected void initProjectRealPath(String projectRealPath) {
		PROJECT_REAL_PATH = projectRealPath;
		PROJECT_CLASS_PATH = PROJECT_REAL_PATH + "WEB-INF\\classes\\";
	}

	public static String getProjectRealPath() {
		return PROJECT_REAL_PATH;
	}

	public static String getProjectClassPath() {
		return PROJECT_CLASS_PATH;
	}
}
