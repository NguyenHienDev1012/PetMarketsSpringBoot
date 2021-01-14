package com.petmarkets2020.model;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UsersModel {
	   private  String uid;
	    private String pwd;
	    private String fullName;
	    private String email;
	    private String gender;
	    private String dateOfBirth;
	    private double coins;
	    private double latitude;
	    private double longitude;
	    private String address;
	    private List<String> favorites;
	    private String phoneNumber;
	    private String avatar;
	    private boolean isEmailVerified;
	    private boolean isPhoneVerified;
	    private String joinDate;

	    public UsersModel() {
	    }

	    // Register 1
	    public UsersModel(String uid, String pwd, String fullName, String gender, String dateOfBirth, String phoneNumber) {
	        this.uid = uid;
	        this.pwd = BCrypt.hashpw(pwd, BCrypt.gensalt(12));
	        this.fullName = fullName;
	        this.gender = gender;
	        this.dateOfBirth = dateOfBirth;
	        this.phoneNumber = phoneNumber;
	        this.isEmailVerified = false;
	        this.isPhoneVerified = false;
	        this.joinDate = Utils.getCurrentDate();
	    }
	    

	    public String getUid() {
	        return uid;
	    }

	    public void setUid(String uid) {
	        this.uid = uid;
	    }

	    public String getPwd() {
	        return pwd;
	    }

	    public void setPwd(String pwd) {
	        this.pwd = pwd;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(String dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }

	    public double getCoins() {
	        return coins;
	    }

	    public void setCoins(double coins) {
	        this.coins = coins;
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

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public List<String> getFavorites() {
	        return favorites;
	    }

	    public void setFavorites(List<String> favorites) {
	        this.favorites = favorites;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAvatar() {
	        return avatar;
	    }

	    public void setAvatar(String avatar) {
	        this.avatar = avatar;
	    }

	    public boolean isEmailVerified() {
	        return isEmailVerified;
	    }

	    public void setEmailVerified(boolean emailVerified) {
	        isEmailVerified = emailVerified;
	    }

	    public boolean isPhoneVerified() {
	        return isPhoneVerified;
	    }

	    public void setPhoneVerified(boolean phoneVerified) {
	        isPhoneVerified = phoneVerified;
	    }

	    public String getJoinDate() {
	        return joinDate;
	    }

	    public void setJoinDate(String joinDate) {
	        this.joinDate = joinDate;
	    }

}
