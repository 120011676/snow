package org.qq120011676.snow.util;

public class ProjectUtils {

	private static String PROJECT_REAL_PATH;

	private static String PROJECT_CLASS_PATH;

	protected void initProjectRealPath(String projectRealPath) {
		PROJECT_REAL_PATH = projectRealPath;
	}

	protected void initProjectClassPath(String projectClassPath) {
		PROJECT_CLASS_PATH = projectClassPath;
	}

	public static String getProjectRealPath() {
		return PROJECT_REAL_PATH;
	}

	public static String getProjectClassPath() {
		return PROJECT_CLASS_PATH;
	}
}
