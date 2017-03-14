package com.xcesys.extras.framework.util;

public class StringUtils {

	public static boolean isBlank(String cs) {
		return cs == null || cs.trim().length() == 0;
	}

	public static String nullSafeToString(Object object) {
		if (object == null) {
			return null;
		}
		return object.toString();
	}

	public static String parenthesize(Object object) {
		return parenthesize(nullSafeToString(object));
	}

	public static String parenthesize(String text) {
		return "(" + text + ")";
	}

	public static String quote(Object object) {
		return quote(nullSafeToString(object));
	}

	public static String quote(String text) {
		return "\"" + text + "\"";
	}
}
