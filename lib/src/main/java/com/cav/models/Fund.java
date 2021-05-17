package com.cav.models;

public class Fund {

	String name;
	String action;
	public Fund(String name, String action) {
		super();
		this.name = name;
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "Fund [name=" + name + ", action=" + action + "]";
	}
}
