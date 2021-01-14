package com.petmarkets2020.model;

public class Comments {
	private String content;
	private String time;
	private String userId;

	public Comments(String content, String time, String userId) {
		this.content = content;
		this.time = time;
		this.userId = userId;
	}
	public Comments() {}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comments [ content=" + content + ", time=" + time + ", userId=" + userId + "]";
	}

}
