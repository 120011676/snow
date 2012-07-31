package org.qq120011676.snow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DATE_STRING = "yyyy-MM-dd";

	public static final String DATE_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	public static Date getDate() {
		return new Date();
	}

	public static Date getStringToDate(String dateString) throws ParseException {
		return new SimpleDateFormat().parse(dateString);
	}

	public static String getDateToString() {
		return DateUtils.getDateToString(DateUtils.DATE_TIMESTAMP, null);
	}

	public static String getDateToString(String pattern) {
		return DateUtils.getDateToString(pattern, null);
	}

	public static String getDateToString(String pattern, Date date) {
		return new SimpleDateFormat(pattern).format(date == null ? DateUtils
				.getDate() : date);
	}

	public static String getDateStringToString(String pattern, String dateString)
			throws ParseException {
		return new SimpleDateFormat(pattern).format(DateUtils
				.getStringToDate(dateString));
	}
}
