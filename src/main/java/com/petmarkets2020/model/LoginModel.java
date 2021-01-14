package com.petmarkets2020.model;

public class LoginModel {
	private String uid;
	private String password;

	public LoginModel() {
	};

	public LoginModel(String uid, String password) {
		this.uid = uid;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [uid=" + uid + ", password=" + password + "]";
	}

}
