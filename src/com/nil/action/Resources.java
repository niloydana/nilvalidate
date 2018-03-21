package com.nil.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Resources {
	private ArrayList<Method> methodList = new ArrayList<>();

	public void parseResource(ArrayList strArrayList) throws ResourceException {
		// TODO Auto-generated method stub
		Method method = null;
		ArrayList<String> arr = new ArrayList<>();
		for (Object obj : strArrayList) {
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);

			if (spaceIndex == 1) {
				if (method != null) {
					methodList.add(method);
				}
				if (tagName.equals("post")) {
					method = new PostMethod();
				} else if (tagName.equals("get")) {
					method = new GetMethod();
				}
			} else if (spaceIndex > 1) {
				// arr = new ArrayList();
				arr.add(lineString);
			} 
			else if (spaceIndex < 1) {
				throw new ResourceException("Invalid Format");
			} 
		}
		if (method != null) {
			method.parse(arr);
			method.printMethod(strArrayList);
		}

	}

	public void printResource() {
		// TODO Auto-generated method stub

	}

}
