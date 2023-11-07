package com.IBatisConfigurationThroughXml.Entity;

import java.util.Map;

public class UserDetails {
	private int id;
	private String username;

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

	public UserDetails(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public UserDetails() {
		super();
	}

	public UserDetails(Map<String, Object> m) {
		this.id = (int) m.get("id");
		this.username = (String) m.get("username");
	}
}
