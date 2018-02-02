package com.nil.action;

import java.util.Scanner;

public class RamlReader {
	private Scanner scan;
	// private RAMLImpl ramlImpl;
	private RamlReader ramlReader;

	public RamlReader(Scanner scan) {
		this.scan = scan;
	}

	public void read() {
		// TODO Auto-generated method stub
		// ramlImpl = new RAMLImpl();
		while (scan.hasNext()) {
			StringBuffer str = new StringBuffer(scan.next().trim());
			// StringBuffer str = new StringBuffer(line1.trim());
			// System.out.println("NEXT LINE is " + str.toString());

			String nextTag = Tag.checkNextTag(str.toString());
			StringBuffer tagType = new StringBuffer("empty");
			if (nextTag != null) {
				if (nextTag.substring(0, 1).equals("/")) {
					tagType = new StringBuffer("resources");
				}

				System.out.println("NEXT TAG is " + nextTag);
				switch (tagType.toString()) {
				case "resources":
					Resources resource = new Resources();
					resource.parseResources(scan);
					System.out.println("RESOURCES");
					break;
				}

			}
		}
	}

	
}
