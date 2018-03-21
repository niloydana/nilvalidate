package com.nil.action;

public enum MediaType {json("application/json"),xml("application/xml");
	private String text;
	MediaType(String str) {
		this.text=str;
	}

	public static void checkForValidity(String tagValue) throws RamlException {
		// TODO Auto-generated method stub
		
		if (!(tagValue.trim().equals("application/json"))) {
			throw new RamlException("Invalid media type");
		}

	}

}
