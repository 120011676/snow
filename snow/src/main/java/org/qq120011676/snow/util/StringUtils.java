package org.qq120011676.snow.util;

public class StringUtils {

	public static boolean isNull(String value) {
		if (value == null || "".equals(value.trim())) {
			return true;
		}
		return false;
	}
}
