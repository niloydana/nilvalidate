package com.nil.action;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class RamlTree {
	public static StringBuffer[] ramlArray = new StringBuffer[100];

	public StringBuffer[] getRamlArray() {
		return ramlArray;
	}

	public void setRamlArray(StringBuffer[] ramlArray) {
		this.ramlArray = ramlArray;
	}

	public static List getSubTree(int i, List tempList) {

		List list = new ArrayList<>();
		for (Object obj : tempList) {
			String lineString = (String) obj;
			int index = lineString.indexOf(":");
			if (index != -1) {
				String tagString = lineString.substring(0, index);
				int lineStringLength = lineString.length();
				int spaceIndex = tagString.lastIndexOf(" ");
				if (spaceIndex > i) {
					list.add(lineString);
				} else {
					break;
				}
			} else {
				list.add(lineString);
			}
		}

		return list;
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
			ramlArray[i] = new StringBuffer(thisLine);
			i++;
		}
	}
}
