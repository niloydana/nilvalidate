package com.nil.action;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RamplParser {
	private ArrayList strArrayList = new ArrayList<>();
	private ArrayList<Object> objectList = new ArrayList<>();
	private Map<String, Object> objectMap;

	public RamplParser() {
	}

	public void parse(int hierarchyLevel) throws IOException, RamlException {
		String thisLine = "";
		String ramlVersionString = RamlTree.ramlArray[0].toString();
		validateRamlVersion(ramlVersionString);
		objectMap = new HashMap<String, Object>();
		int i = 1;
		while (true) {
			objectMap = new HashMap<String, Object>();
			strArrayList = new ArrayList<>();
			thisLine = null;
			if (RamlTree.ramlArray[i] != null) {
				thisLine = RamlTree.ramlArray[i].toString();
			}
			if (thisLine == null) {
				break;
			}
			if (thisLine.trim().equals("")) {
				break;
			}

			int tagEndIndex = thisLine.indexOf(":");
			if (tagEndIndex < 0) {
				strArrayList.add(thisLine);
				continue;
			}
			int totalLength = thisLine.length();

			String tagString = thisLine.substring(0, tagEndIndex);
			int emptySpaces = tagString.lastIndexOf(' ');

			int tagStartIndex = 0;
			if (emptySpaces > 0) {
				tagStartIndex = emptySpaces;
			}
			if (totalLength == (tagEndIndex + 1)) {
				while (true) {
					// objectMap.put(tagString,"test");
					// String nextLine = lnr.readLine();
					i++;
					String nextLine = null;
					if (RamlTree.ramlArray[i] != null) {
						nextLine = RamlTree.ramlArray[i].toString();
					}
					if (nextLine == null) {
						break;
					}
					if (nextLine.trim().equals("")) {
						break;
					}
					int innerTagEndIndex = nextLine.indexOf(":");
					if (innerTagEndIndex < 0) {
						strArrayList.add(nextLine);
						continue;
					}
					String innerTagString = nextLine.substring(0, innerTagEndIndex);
					int innerEmptySpaces = innerTagString.lastIndexOf(' ');
					if (innerEmptySpaces == -1) {
						innerEmptySpaces = innerTagString.lastIndexOf('\t');
					}
					int innerTagStartIndex = 0;
					if (innerEmptySpaces > 0) {
						innerTagStartIndex = innerEmptySpaces;
					}
					if (innerEmptySpaces == emptySpaces) {
						i--;
						break;
					}
					strArrayList.add(nextLine);
					continue;
				}
				validateTag(tagString, strArrayList);
				objectMap.put(tagString, strArrayList);

			} else {
				String tagValue = thisLine.substring(tagEndIndex + 1, totalLength);
				strArrayList.add(thisLine);
				validateOneLinerTag(tagString, tagValue);
				objectMap.put(tagString, tagValue);
			}
			objectList.add(objectMap);
			i++;
		}
		printObject(objectList);

	}

	private void printObject(ArrayList<Object> objectList2) {
		for (Object obj : objectList) {
			Map<String, Object> map = (Map<String, Object>) obj;
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> pair = it.next();
				System.out.println(pair.getKey() + "/" + pair.getValue());
			}
		}
	}

	private void validateRamlVersion(String ramlVersionString) throws RamlException {
		if (!(ramlVersionString.equals("#%RAML 1.0")) || (ramlVersionString.equals("#%RAML 0.8"))) {
			throw new RamlException("Invalid Version");
		}

	}

	private void validateOneLinerTag(String tagString, String tagValue) throws RamlException {
		if (tagString.equals("version")) {
			System.out.println("Parsing Version...");

		} else if (tagString.equals("baseUri")) {
			System.out.println("Parsing baseUri...");

		} else if (tagString.equals("mediaType")) {
			System.out.println("Parsing mediaType...");
			MediaType.checkForValidity(tagValue);

		}

	}

	private void validateTag(String tagString, ArrayList strArrayList) throws RamlException, IOException {
		if (tagString.equals("types")) {
			System.out.println("Parsing Types Data...");
			Types types = new Types();
			types.parseTypes(strArrayList);
			types.printTypes();

		} else if (tagString.charAt(0) == '/') {
			System.out.println("Parsing Resource Data...");
			if (!RamlDictionary.checkForNoun(tagString.substring(1))) {
				throw new ResourceException("Resource Not noun");
			}

			Resources resource = new Resources();
			resource.parseResource(strArrayList);
			resource.printResource();

		} else if (tagString.equals("securitySchemes")) {
			System.out.println("Parsing securitySchemes...");
			SecuritySchemes secSchemes = new SecuritySchemes();
			secSchemes.parseSecuritySchemes(strArrayList);
			secSchemes.printSecurityScheme();

		}

	}

	private void parseTypes(StringBuilder strBuilder2) {
		// TODO Auto-generated method stub

	}

	public void readRaml(LineNumberReader lnr) throws IOException {
		int i = 0;
		while (true) {
			String thisLine = lnr.readLine();
			if (thisLine == null) {
				break;
			}
			if (thisLine.trim().equals("")) {
				break;
			}
			RamlTree.ramlArray[i] = new StringBuffer(thisLine);
			i++;
		}
	}

}
