package com.nil.action;

public class Tag {

	public static String checkNextTag(String string) {
		int index = string.indexOf(":");
		if (string.equals("") || (index < 2)) {
			return null;
		}

		return string.substring(0, index);

	}

}
