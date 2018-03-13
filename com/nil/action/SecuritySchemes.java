package com.nil.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecuritySchemes {
	private ArrayList<SecurityScheme> securitySchemesList = new ArrayList<>();

	public void parseSecuritySchemes(ArrayList strArrayList) throws RamlException {
		// TODO Auto-generated method stub
		SecurityScheme securityScheme = null;
		int lineNumber = 1;
		int sizeOfList = strArrayList.size();
		
		for (Object obj : strArrayList) {
			
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);

			if (spaceIndex == 1) {
				if (securityScheme != null) {
					securitySchemesList.add(securityScheme);
				}
				securityScheme = new SecurityScheme(tagName);
				List tempList = strArrayList.subList(lineNumber, sizeOfList-1);
			//	List subList = RamlTree.getSubTree(2,tempList);
				
				securityScheme.parseScheme(tempList);

			}
			lineNumber++;
		}

	}

	private void validateType(String tagValue) throws RamlException {
		// TODO Auto-generated method stub
		if (!((tagValue.trim()).equals("OAuth 2.0") || (tagValue.trim()).equals("OAuth 1.0"))) {
			throw new RamlException("Invalid Type");
		}
	}

	public void printSecurityScheme() {
		// TODO Auto-generated method stub

	}
	

}
