package org.qq120011676.snow.util;

public class ProjectHomeUtils {

	private static String HOME;

	protected void init(String home) {
		ProjectHomeUtils.HOME = home;
	}

	public static String getHome() {
		return ProjectHomeUtils.HOME;
	}
}
