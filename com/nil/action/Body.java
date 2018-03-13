package com.nil.action;

import java.util.Scanner;

public class Body {

	public void parseBody(Scanner scan) {
		// TODO Auto-generated method stub
		while (scan.hasNext()) {
			StringBuffer str = new StringBuffer(scan.next().trim());
			// StringBuffer str = new StringBuffer(line1.trim());
			// System.out.println("NEXT LINE is " + str.toString());

			String nextTag = Tag.checkNextTag(str.toString());
			System.out.println("TAG is " + nextTag);
			StringBuffer tagType = new StringBuffer("empty");
			if (nextTag != null) {
				if (nextTag.substring(0, 1).equals("/")) {
					tagType = new StringBuffer("resources");
				}

				System.out.println("NEXT TAG is " + nextTag);
				switch (nextTag.toString()) {
				case "application/json":
					
					System.out.println("application/json");
			
				}

			}
		}
	}

}
