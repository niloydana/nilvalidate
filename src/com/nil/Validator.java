package com.nil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.nil.action.RamlReader;

public class Validator {
	private static Scanner scan;

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0) {
			System.out.println("Enter the raml file name");
		} else {
			String fileName = args[0];
			System.out.println("filename is " + fileName);
			scan = extracted(fileName).useDelimiter("\n");
			System.out.println("filename is " + fileName);
			RamlReader ramlReader = new RamlReader(scan);
			ramlReader.read();

		}
	}

	private static Scanner extracted(String fileName) throws FileNotFoundException {
		return new Scanner(new File(fileName));
	}
}
