package com.nil.action;

public class Tag {

	public static String checkNextTag(String string) {
		int index = string.indexOf(":");
		if (string.equals("") || (index < 2)) {
			return null;
		}

		return string.substring(0, index);

	}

	public static String nextTagAtLevel(int i, String string) {
		int index = string.indexOf(":");
		
		String tagString = string.substring(0,index);
		int emptySpaces = tagString.lastIndexOf(' ');
		System.out.println("EMP "+emptySpaces+"for string"+string);
		//System.out.println("String from Check.." + string);
		int startIndex = 2 * i - 2;
		
		System.out.println("String from Check2.." + string.substring(startIndex, index));
		if (string.equals("") || (index < 2)) {
			return null;
		}

		return string.substring(startIndex, index);
	}
}
