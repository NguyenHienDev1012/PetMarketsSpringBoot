package com.petmarkets2020.model;

public class Rankings {
	private String comment;
	private String postId;
	private int rate;
	private String time;
	private String userId;
	public Rankings(String comment, String postId, int rate, String time, String userId) {
		super();
		this.comment = comment;
		this.postId = postId;
		this.rate = rate;
		this.time = time;
		this.userId = userId;
	}
	public Rankings() {
		super();
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
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
	
}
