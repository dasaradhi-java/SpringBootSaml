package com.IBatisConfigurationThroughXml.Entity;

import java.util.List;

public class ConsolidateDataForUserandROle {
	private List<UserDetails> users;
	private List<Role> roles;
	public List<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public ConsolidateDataForUserandROle(List<UserDetails> users, List<Role> roles) {
		super();
		this.users = users;
		this.roles = roles;
	}
	public ConsolidateDataForUserandROle() {
		super();
	}

	

}
