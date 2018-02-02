package com.nil.action;

import java.util.Scanner;

public class GetMethod extends Method{

	public void parseGetMethod(Scanner scan) {
		while (scan.hasNext()) {
			StringBuffer str = new StringBuffer(scan.next().trim());
			// StringBuffer str = new StringBuffer(line1.trim());
			// System.out.println("NEXT LINE is " + str.toString());
			
			String nextTag = Tag.checkNextTag(str.toString());
			System.out.println("TAG is "+nextTag);
			StringBuffer tagType=new StringBuffer("empty");
			if (nextTag != null) {
				if(nextTag.substring(0, 1).equals("/")) {
					 tagType = new StringBuffer("resources");
				}
				 
				System.out.println("NEXT TAG is " + nextTag);
				switch (nextTag.toString()) {
				case "queryParameters":
					//GetMethod getMethod = new GetMethod();
					//getMethod.parseGetMethod(scan);
					//resource.parseResources(scan);
					System.out.println("queryParameters");
				case "responses":
					Responses responses = new Responses();
					responses.parseResponse(scan);
					//getMethod.parseGetMethod(scan);
					//resource.parseResources(scan);
					System.out.println("responses");
				}
					
			}
		}
	}

}
