package com.nil.action;

import java.util.List;
import java.util.Scanner;

public class Resources {
private List methodList;
public Resources parseResources(Scanner scan) {
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
			case "get":
				GetMethod getMethod = new GetMethod();
				getMethod.parseGetMethod(scan);
				//resource.parseResources(scan);
				System.out.println("Get");
				break;
			case "post":
				PostMethod postMethod = new PostMethod();
				postMethod.parsePostMethod(scan);
				//resource.parseResources(scan);
				System.out.println("Post");
				break;
			}
				
		}
		
	}
	return null;
	
}
private PostMethod parsePostMethod() {
	// TODO Auto-generated method stub
	return null;
}
private GetMethod parseGetMethod() {
	return null;
	// TODO Auto-generated method stub
	
}
private Object parseMethod() {
	// TODO Auto-generated method stub
	return null;
}

}
