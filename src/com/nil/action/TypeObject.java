package com.nil.action;

import java.util.Map;

public class TypeObject {

	public TypeObject(String name2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
	}

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map getProperties() {
		return properties;
	}
	public void setProperties(Map properties) {
		this.properties = properties;
	}

	private Map properties;

}
