package com.nil.action;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMethod extends Method {

	@Override
	public void parse(ArrayList<String> strArrayList) throws ResourceException {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>();
		Responses responses = null;
		MethodHeader header=null;
		MethodBody body = null;
		for (Object obj : strArrayList) {
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);

			if (spaceIndex == 3) {
				if (tagName.equals("headers")) {
					 header = new MethodHeader();
					//this.setHeader(header);
				} else if (tagName.equals("body")) {
					 body = new MethodBody();
					this.setBody(body);
				} else if (tagName.equals("responses")) {
					 responses = new Responses();
					this.setResponses(responses);
				}

			} else if (spaceIndex > 3) {
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
