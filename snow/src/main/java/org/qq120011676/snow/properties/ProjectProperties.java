package org.qq120011676.snow.properties;

import java.util.HashMap;
import java.util.Map;

public class ProjectProperties {

	public static final String DEFAULT_FILE_EXTENSION_NAME = ".properties";

	public static final String DEFAULT_MESSAGES_FILE_NAME = "messages";

	public static final String DEFAULT_CONFIG_FILE_NAME = "config";

	private static Map<String, String> CONFIG_MAP = new HashMap<String, String>();

	private static Map<String, String> MESSAGES_MAP = new HashMap<String, String>();

	public static String getConfig(String name) {
		return CONFIG_MAP.get(name);
	}

	public static String getConfig(String name, Map<String, String> map) {
		return ProjectProperties
				.setMessagesParameter(CONFIG_MAP.get(name), map);
	}

	public static int getConfigToInt(String name) {
		return Integer.parseInt(CONFIG_MAP.get(name));
	}

	public static int getConfigToInt(String name, Map<String, String> map) {
		return Integer.parseInt(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	public static double getConfigToDouble(String name) {
		return Double.parseDouble(CONFIG_MAP.get(name));
	}

	public static double getConfigToDouble(String name, Map<String, String> map) {
		return Double.parseDouble(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	public static long getConfigToLong(String name) {
		return Long.parseLong(CONFIG_MAP.get(name));
	}

	public static long getConfigToLong(String name, Map<String, String> map) {
		return Long.parseLong(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	public static float getConfigToFloat(String name) {
		return Float.parseFloat(CONFIG_MAP.get(name));
	}

	public static float getConfigToFloat(String name, Map<String, String> map) {
		return Float.parseFloat(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	public static boolean getConfigToBoolean(String name) {
		return Boolean.parseBoolean(CONFIG_MAP.get(name));
	}

	public static boolean getConfigToBoolean(String name,
			Map<String, String> map) {
		return Boolean.parseBoolean(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	public static short getConfigToShort(String name) {
		return Short.parseShort(CONFIG_MAP.get(name));
	}

	public static short getConfigToShort(String name, Map<String, String> map) {
		return Short.parseShort(ProjectProperties.setMessagesParameter(
				CONFIG_MAP.get(name), map));
	}

	protected void initConfig(Map<String, String> map) {
		CONFIG_MAP = map;
	}

	protected void initMessages(Map<String, String> map) {
		MESSAGES_MAP = map;
	}

	public static String getMessage(String name) {
		return MESSAGES_MAP.get(name);
	}

	public static String getMessage(String name, Map<String, String> map) {
		return ProjectProperties.setMessagesParameter(MESSAGES_MAP.get(name),
				map);
	}

	public static String setMessagesParameter(String message, String name,
			String value) {
		return message.replaceAll("\\$\\{[ ]*" + name + "[ ]*\\}", value);
	}

	public static String setMessagesParameter(String message,
			Map<String, String> map) {
		for (String key : map.keySet()) {
			message = setMessagesParameter(message, key, map.get(key));
		}
		return message;
	}
}
