package com.IBatisConfigurationThroughXml.Entity;

import java.util.Map;

public class UserRequest {
	private int id;
	private String username;
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRequest(Map<String, Object> m) {
		this.id = (int) m.get("id");
		this.username = (String) m.get("username");

	}

	public UserRequest() {
		// TODO Auto-generated constructor stub
	}

}