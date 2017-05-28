package edu.hm.oauth.model;

import java.io.Serializable;

public class AuthData implements Serializable{

	private String name;
	private String password;

	private AuthData() {
	}

	public AuthData(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
