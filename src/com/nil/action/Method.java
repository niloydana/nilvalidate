package com.nil.action;

import java.util.ArrayList;
import java.util.Map;

public abstract class Method {
	private MethodHeader header;
	private MethodBody body;
	private Responses responses;
	public MethodHeader getHeader() {
		return header;
	}
	public void setHeader(MethodHeader header) {
		this.header = header;
	}
	public MethodBody getBody() {
		return body;
	}
	public void setBody(MethodBody body) {
		this.body = body;
	}
	abstract public void parse(ArrayList<String> strArrayList) throws ResourceException;
	public void printMethod(ArrayList<String> strArrayList) {
		// TODO Auto-generated method stub
		for (String to : strArrayList) {
		}
	}
	public Responses getResponses() {
		return responses;
	}
	public void setResponses(Responses responses) {
		this.responses = responses;
	}
	
}
