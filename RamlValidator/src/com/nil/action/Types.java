package com.nil.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Types {

	private ArrayList<TypeObject> typeObjectList = new ArrayList<>();

	public void parseTypes(ArrayList strArrayList) throws TypeException {
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

	public void printTypes() {
		for (TypeObject to : typeObjectList) {
			Map<String, String> map = to.getProperties();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println("Map Key Value is..." + entry.getKey() + "/" + entry.getValue());
			}
		}
	}

}
