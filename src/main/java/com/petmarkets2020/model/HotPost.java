package com.petmarkets2020.model;

public class HotPost {
	private int days;
	private String pkgId;
	private String postId;
	private String startTime;

	public HotPost() {
	}

	public HotPost(int days, String pkgId, String postId, String startTime) {
		super();
		this.days = days;
		this.pkgId = pkgId;
		this.postId = postId;
		this.startTime = startTime;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getPkgId() {
		return pkgId;
	}

	public void setPkgId(String pkgId) {
		this.pkgId = pkgId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
