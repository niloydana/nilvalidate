package com.nil.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.nil.Validator;

public class SecuritySchemes {
	private ArrayList<SecurityScheme> securitySchemesList = new ArrayList<>();

	public void parseSecuritySchemes(ArrayList strArrayList) throws RamlException, IOException {
		// TODO Auto-generated method stub
		if (strArrayList.size() == 1) {
			String tagLine = (String) strArrayList.get(0);
			int tagIndex = tagLine.indexOf(":");
			String tagValue = tagLine.substring(tagIndex+1, tagLine.length());
			if (tagValue.startsWith("!include")) {
				int fileIndex = tagValue.indexOf("!include");
				String fileName = tagValue.substring(9);
				Properties prop = System.getProperties();
				String inFileName = Validator.filePath+"\\"+fileName;
				String updatedFile = inFileName.replace("/", "\\");
				File file = new File(updatedFile);
				if(!file.exists()) {
					throw new RamlException("Nested RAML does not exist");
				} else {
					ArrayList arrList = createInlineArray(file);
					parseSecuritySchemes(arrList);
					System.out.println("test");
				}
				System.out.println("prop" +Validator.filePath);
			} else {
				throw new RamlException("Syntax Error");
			}
		}
		SecurityScheme securityScheme = null;
		int lineNumber = 1;
		int sizeOfList = strArrayList.size();
		int lastSpaceIndex = 0;
		List tempList = new ArrayList<String>();
		for (Object obj : strArrayList) {

			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			if (index != -1) {
				String tagString = lineString.substring(0, index);
				int lineStringLength = lineString.length();
				int spaceIndex = tagString.lastIndexOf(" ");
				String tagName = tagString.substring(spaceIndex + 1, index);

				if (spaceIndex == 1) {
					if (securityScheme != null) {
						securitySchemesList.add(securityScheme);
					}
					String currentScheme = tagName;
					securityScheme = new SecurityScheme(currentScheme);
					if (lastSpaceIndex < 1) {
						tempList.add(lineString);
					} else {
						lastSpaceIndex = 0;
						securityScheme.parseScheme(tempList);
						tempList.clear();
						tempList.add(lineString);

					}

				} else if (spaceIndex > 1) {

					tempList.add(lineString);
					lastSpaceIndex = spaceIndex;
				}
				lineNumber++;
			}
		}

	}

	private ArrayList createInlineArray(File file) throws IOException {
		// TODO Auto-generated method stub
		ArrayList arrList = new ArrayList();
		String str;
		LineNumberReader lnreader = new LineNumberReader(new FileReader(file));
		while((str = lnreader.readLine()) != null) {
			arrList.add(str);
		}
		return arrList;
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
