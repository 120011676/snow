package org.qq120011676.snow.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.qq120011676.snow.properties.ProjectProperties;

public class JSONUtils {

	private final static String CODE = "code";

	private final static String RESULTS = "results";

	private final static String DESCRIPTION = "description";

	private final static boolean SUCCESS_CODE = true;

	private final static boolean ERROR_CODE = false;

	private final static String SUCCESS_DESCRIPTION = "ok";

	public static JSONObject success() throws JSONException {
		return JSONUtils.newJSONObject(SUCCESS_CODE, SUCCESS_DESCRIPTION);
	}

	public static JSONObject success(JSONObject jsonObject)
			throws JSONException {
		return JSONUtils.newJSONObject(SUCCESS_CODE, SUCCESS_DESCRIPTION).put(
				RESULTS, jsonObject);
	}

	public static JSONObject success(JSONArray jsonArray) throws JSONException {
		return JSONUtils.newJSONObject(SUCCESS_CODE, SUCCESS_DESCRIPTION).put(
				RESULTS, jsonArray);
	}

	public static JSONObject error(String errorInfo) throws JSONException {
		return JSONUtils.newJSONObject(ERROR_CODE, errorInfo);
	}

	public static JSONObject errorMessageName(String name) throws JSONException {
		return JSONUtils.newJSONObject(ERROR_CODE,
				ProjectProperties.getMessage(name));
	}

	private static JSONObject newJSONObject(boolean code, String description)
			throws JSONException {
		return new JSONObject().put(CODE, code).put(DESCRIPTION, description);
	}
}
