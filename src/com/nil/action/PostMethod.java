package com.nil.action;

import java.util.ArrayList;
import java.util.Scanner;

public class PostMethod extends Method{

	@Override
	public void parse(ArrayList<String> strArrayList) throws ResourceException {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>();
		MethodHeader header = new MethodHeader();
		MethodBody body = new MethodBody();
		for (Object obj : strArrayList) {
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);

			if (spaceIndex == 3) {
				if (tagName.equals("headers")) {
					
					this.setHeader(header);
				} else if (tagName.equals("body")) {
					
					this.setBody(body);
				}

			} else if (spaceIndex > 3){
				arr.add(lineString);
			} else {
				throw new ResourceException("Invalid Format");
			}

		}
		if (header != null) {
			header.parse(arr);
		}
		if (body != null) {
			body.parse(arr);
		}
	}


}
