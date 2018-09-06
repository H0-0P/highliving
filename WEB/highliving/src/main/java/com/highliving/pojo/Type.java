package com.highliving.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type {
	
	private String name;
	
	private List<?> type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<?> getType() {
		return type;
	}
	public void setType(List<?> type) {
		this.type = type;
	}
	
}
