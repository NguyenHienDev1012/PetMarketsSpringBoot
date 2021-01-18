package com.petmarkets2020.model;

import java.util.ArrayList;
import java.util.List;

public class PostModel {
	private String postId;
	private String area;
	private boolean isActive;
	private double latitude;
	private double longitude;
	private long limitDay;
	private long price;
	private boolean hidden;
	private String timeStart;
	private String breed;
	private String peAge;
	private String peType;
	private String poType;
	private String poster;
	private String gender;
	private String timeActive;
	private String title;
	private int status;
	private long viewCounts;
	private String healthGuarantee;
	private String injectStatus;
	private List<String> images;
	public PostModel(String postId, String area, boolean isActive, boolean hidden, double latitude, double longitude,
			long limitDay, long price, String timeStart, String breed, String peAge, String peType, String poType,
			String poster, String gender, String timeActive, String title, int status, long viewCounts,
			String healthGuarantee, String injectStatus, List<String> images) {
		super();
		this.postId = postId;
		this.area = area;
		this.isActive = isActive;
		this.hidden = hidden;
		this.latitude = latitude;
		this.longitude = longitude;
		this.limitDay = limitDay;
		this.price = price;
		this.timeStart = timeStart;
		this.breed = breed;
		this.peAge = peAge;
		this.peType = peType;
		this.poType = poType;
		this.poster = poster;
		this.gender = gender;
		this.timeActive = timeActive;
		this.title = title;
		this.status = status;
		this.viewCounts = viewCounts;
		this.healthGuarantee = healthGuarantee;
		this.injectStatus = injectStatus;
		this.images = images;
	}
	public PostModel() {
		super();
	}
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getLimitDay() {
		return limitDay;
	}

	public void setLimitDay(long limitDay) {
		this.limitDay = limitDay;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getPeAge() {
		return peAge;
	}

	public void setPeAge(String peAge) {
		this.peAge = peAge;
	}

	public String getPeType() {
		return peType;
	}

	public void setPeType(String peType) {
		this.peType = peType;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTimeActive() {
		return timeActive;
	}

	public void setTimeActive(String timeActive) {
		this.timeActive = timeActive;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getViewCounts() {
		return viewCounts;
	}

	public void setViewCounts(long viewCounts) {
		this.viewCounts = viewCounts;
	}

	public String getHealthGuarantee() {
		return healthGuarantee;
	}

	public void setHealthGuarantee(String healthGuarantee) {
		this.healthGuarantee = healthGuarantee;
	}

	public String getInjectStatus() {
		return injectStatus;
	}

	public void setInjectStatus(String injectStatus) {
		this.injectStatus = injectStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getImages() {
		return urlImages((ArrayList<String>) images);
	};

	public void setImages(List<String> images) {
		this.images = images;
	}

	public ArrayList<String> urlImages(ArrayList<String> images) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < images.size(); i++) {
			String arr[] = images.get(i).split("/");
			list.add(arr[1]);
		}
		return list;
	}

	@Override
	public String toString() {
		return "PostModel [postId=" + postId + ", area=" + area + ", isActive=" + isActive + ", hidden=" + hidden
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", limitDay=" + limitDay + ", price=" + price
				+ ", timeStart=" + timeStart + ", breed=" + breed + ", peAge=" + peAge + ", peType=" + peType
				+ ", poType=" + poType + ", poster=" + poster + ", gender=" + gender + ", timeActive=" + timeActive
				+ ", title=" + title + ", viewCounts=" + viewCounts + ", healthGuarantee=" + healthGuarantee
				+ ", injectStatus=" + injectStatus + ", status=" + status + ", images=" + images + "]";
	}
	
}
