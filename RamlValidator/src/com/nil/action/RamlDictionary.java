package com.nil.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RamlDictionary {

	public static boolean checkForNoun(String tagString) {
		// TODO Auto-generated method stub

		try {

			URL url = new URL("https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+tagString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("app_id", "24671146");
			conn.setRequestProperty("app_key", "372f4dd3f7a89da7f5b9421c5bc724ef");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Checking the resource type .... \n");
			while ((output = br.readLine()) != null) {
				if (output.contains("\"lexicalCategory\":")) {
					if (output.contains("\"Noun\"")) {
						System.out.println(output);
						return true;

					} else if(output.contains("\"Verb\"")) {
						System.out.println(output);
						return false;
					} 
					return false;
				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return false;
	}

}
