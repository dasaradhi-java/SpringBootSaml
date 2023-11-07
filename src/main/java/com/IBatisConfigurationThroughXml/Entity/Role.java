package com.IBatisConfigurationThroughXml.Entity;

import java.util.Map;

public class Role {
    private int id;
    private String name;
	public Role(int id, String name) {		
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role() {
		super();
	}
	 public Role(Map<String,Object> m) {
		 this.id=  (int) m.get("role_id");
		 this.name=(String) m.get("role_name");
		 
	 }
    

}