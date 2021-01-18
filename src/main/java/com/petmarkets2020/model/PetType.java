package com.petmarkets2020.model;

import org.springframework.web.bind.annotation.GetMapping;

public class PetType {
	private String image;
	private String name;

	public PetType(String image, String name) {
		super();
		this.image = image;
		this.name = name;
	}

	public PetType() {
		super();
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

//	public String imageSplit(String image) {
//		System.out.println(image);
//		String[] arr = image.split("/");
//		System.out.println(arr[2]);
//		return arr[2];
//
//	}
	public String getImage() {
		String[] arr = null;
		if (image != null) {
			System.out.println(image);
			arr = image.split("/");
			return arr[2];
		}
		return "";
	}
}
