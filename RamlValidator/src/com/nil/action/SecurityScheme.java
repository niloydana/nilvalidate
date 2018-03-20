package com.nil.action;

import java.util.ArrayList;
import java.util.List;

public class SecurityScheme {

	public SecurityScheme(String tagName) {
		// TODO Auto-generated constructor stub
	}

	public void parseScheme(List list) throws RamlException {

		int lineNumber = 1;
		int sizeOfList = list.size();
		for (Object obj : list) {

			String lineString = (String) obj;

			int index = lineString.indexOf(":");
			if (index == -1) {
				lineNumber++;
				continue;
			}
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);
			if (spaceIndex == 3) {

				String tagValue = lineString.substring(index + 1, lineStringLength);
				List subList = list.subList(lineNumber, sizeOfList);
				List subTree = RamlTree.getSubTree(3, subList);
				if (tagName.equals("type")) {
					validateType(tagValue);
				} else if (tagName.equals("description")) {
					validateDescription(tagValue, subTree);
				} else if (tagName.equals("describedBy")) {
					subTree = RamlTree.getSubTree(3, subList);
					validateDescribedBy(tagValue, subTree);
				} else if (tagName.equals("settings")) {
					subTree = RamlTree.getSubTree(3, subList);
					validateSettings(tagValue, subTree);
				} else {
					throw new RamlException("Invalid Type Attribute");
				}

			}
			lineNumber++;
		}

	}

	private void validateDescribedBy(String tagValueArg, List list) throws RamlException {
		int lineNumber = 1;
		int sizeOfList = list.size();
		for (Object obj : list) {

			String lineString = (String) obj;

			int index = lineString.indexOf(":");
			if (index == -1) {
				lineNumber++;
				continue;
			}
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);
			if (spaceIndex == 5) {

				String tagValue = lineString.substring(index + 1, lineStringLength);
				List subList = list.subList(lineNumber, sizeOfList);
				List subTree = RamlTree.getSubTree(5, subList);
				if (tagName.equals("headers")) {
					
				}else if (tagName.equals("queryParameters")) {
					
				}else if (tagName.equals("responses")) {
					
				} else {
					throw new RamlException("Invalid DescribedBy");
				}

			}
			lineNumber++;
		}
		
	}

	private void validateSettings(String tagValueArg, List list) throws RamlException {
		int lineNumber = 1;
		int sizeOfList = list.size();
		for (Object obj : list) {

			String lineString = (String) obj;

			int index = lineString.indexOf(":");
			if (index == -1) {
				lineNumber++;
				continue;
			}
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);
			if (spaceIndex == 5) {

				String tagValue = lineString.substring(index + 1, lineStringLength);
				System.out.println("Tesing");
				List subList = list.subList(lineNumber, sizeOfList);
				List subTree = RamlTree.getSubTree(3, subList);
				if (tagName.equals("authorizationUri")) {
					
				}else if (tagName.equals("accessTokenUri")) {
					
				}else if (tagName.equals("authorizationGrants")) {
					
				} else {
					throw new RamlException("Invalid Settings");
				}

			}
			lineNumber++;
		}

	}

	private void validateDescription(String tagValue, List subList) {
		if (tagValue.equals("|")) {

		}
	}

	private void validateType(String tagValue) throws RamlException {
		// TODO Auto-generated method stub
		if (!((tagValue.trim()).equals("OAuth 2.0") || (tagValue.trim()).equals("OAuth 1.0"))) {
			throw new RamlException("Invalid Type Value");
		}
	}
}
