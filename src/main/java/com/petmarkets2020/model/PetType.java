package com.petmarkets2020.model;

public class PetType {
	private String image;
	private String name;

	public PetType() {
	}

	public PetType(String image, String name) {
		this.image = image;
		this.name = name;
	}

	public String getImage() {
		return imageSplit(image);
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String imageSplit(String image) {
		String[] arr = image.split("/");
		return arr[2];

	}

	@Override
	public String toString() {
		return "PetType [image=" + image + ", name=" + name + "]";
	}

}
