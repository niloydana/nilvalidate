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

public class Types {

	private ArrayList<TypeObject> typeObjectList = new ArrayList<>();

	public void parseTypes(ArrayList strArrayList) throws IOException, RamlException {
		
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
					throw new RamlException("Nested Type RAML does not exist");
				} else {
					ArrayList arrList = createInlineArray(file);
					parseTypes(arrList);
					System.out.println("test");
				}
				System.out.println("prop" +Validator.filePath);
			} else {
				throw new RamlException("Syntax Error");
			}
		}
		TypeObject typeObject = null;
		for (Object obj : strArrayList) {
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			String tagString = lineString.substring(0, index);
			int lineStringLength = lineString.length();
			int spaceIndex = tagString.lastIndexOf(" ");
			String tagName = tagString.substring(spaceIndex + 1, index);

			if (spaceIndex == 1) {
				if (typeObject != null) {
					typeObjectList.add(typeObject);
				}
				typeObject = new TypeObject(tagName);

			} else if (spaceIndex == 3) {
				if (tagName.equals("type")) {
				} else if (tagName.equals("properties")) {
				}

			} else if (spaceIndex == 5) {
				String tagValue = lineString.substring(index, lineStringLength);
				Map prop = new HashMap<>();
				prop.put(tagName, tagValue);
				typeObject.setProperties(prop);

			} else {
				throw new TypeException("Please check the format of data types");
			}

		}

	}

	private ArrayList createInlineArray(File file) throws IOException {
		ArrayList arrList = new ArrayList();
		String str;
		LineNumberReader lnreader = new LineNumberReader(new FileReader(file));
		while((str = lnreader.readLine()) != null) {
			arrList.add(str);
		}
		return arrList;
	}

	public void printTypes() {
		for (TypeObject to : typeObjectList) {
			Map<String, String> map = to.getProperties();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println("Map Key Value is..." + entry.getKey() + "/" + entry.getValue());
			}
		}
	}

}
