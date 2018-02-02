package com.nil.action;

import java.util.Scanner;

public class Responses {
	private int statusCode;
	private Body body;
	private MediaType mediaType;

	public Responses parseResponse(Scanner scan) {
		while (scan.hasNext()) {
			StringBuffer str = new StringBuffer(scan.next().trim());
			String nextTag = Tag.checkNextTag(str.toString());
			System.out.println("TAG is " + nextTag);
			StringBuffer tagType = new StringBuffer("empty");
			if (nextTag != null) {
				if (nextTag.substring(0, 1).equals("/")) {
					tagType = new StringBuffer("resources");
				}

				System.out.println("NEXT TAG is " + nextTag);
				switch (nextTag.toString()) {
				case "200":
					Body body = new Body();
					body.parseBody(scan);
					// getMethod.parseGetMethod(scan);
					// resource.parseResources(scan);
					System.out.println("200");
					break;
				case "401":
					// GetMethod getMethod = new GetMethod();
					// getMethod.parseGetMethod(scan);
					// resource.parseResources(scan);
					System.out.println("401");
					break;
				case "403":
					// GetMethod getMethod = new GetMethod();
					// getMethod.parseGetMethod(scan);
					// resource.parseResources(scan);
					System.out.println("403");
					break;
				case "405":
					// GetMethod getMethod = new GetMethod();
					// getMethod.parseGetMethod(scan);
					// resource.parseResources(scan);
					System.out.println("405");
					break;
				}

			}
		}
		return null;

	}

}
