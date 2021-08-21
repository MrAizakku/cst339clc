package com.gcu.models;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	private Date birthdate;
	private boolean gender;
	private int role;
	
	public UserModel(int userID, String firstName, String lastName, String email, String mobile, String password,
			Date birthdate, boolean gender, int role) {
		super();
		this.ID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.role = role;
	}
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	public int getUserID() {
		return ID;
	}
	public void setUserID(int userID) {
		this.ID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
