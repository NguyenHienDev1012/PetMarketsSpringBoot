package com.petmarkets2020.model;

public class PostPackage {
	private String description;
	private String pkgId;
	private double price;
	private String title;
	public PostPackage() {
		super();
	}
	public PostPackage(String description, String pkgId, double price, String title) {
		super();
		this.description = description;
		this.pkgId = pkgId;
		this.price = price;
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPkgId() {
		return pkgId;
	}
	public void setPkgId(String pkgId) {
		this.pkgId = pkgId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
