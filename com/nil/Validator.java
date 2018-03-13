package com.nil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import com.nil.action.RamlException;
import com.nil.action.RamplParser;
import com.nil.action.ResourceException;
import com.nil.action.TypeException;

public class Validator {
	private static LineNumberReader lnr;

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Enter the raml file name");
		} else {
			String fileName = args[0];
			System.out.println("filename is " + fileName);
			extracted(fileName).useDelimiter("\n");
			System.out.println("filename is " + fileName);
			RamplParser ramlParser = new RamplParser();
			ramlParser.readRaml(lnr);
			try {
				ramlParser.parse(0);
			} catch (TypeException e) {
				// TODO Auto-generated catch block
				System.out.println("Type Exception " + e.getErrorMessage());
				// e.printStackTrace();
			} catch (RamlException re) {
				if (re instanceof TypeException) {
					System.out.println("Type Exception " + re.getErrorMessage());

				} else if (re instanceof ResourceException) {
					System.out.println("Resource Exception " + re.getErrorMessage());
				} else {
					System.out.println("Raml Exception " + re.getErrorMessage());
				}

			}

		}
	}

	private static Scanner extracted(String fileName) throws FileNotFoundException {
		lnr = new LineNumberReader(new FileReader(fileName));
		return new Scanner(new File(fileName));
	}
}
