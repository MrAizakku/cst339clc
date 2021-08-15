package com.gcu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
	private int ID;

	@NotNull(message="First Name is a required field")
	@Size(min=1, max=16, message="First Name must be between 1 and 16 characters")
	private String firstName;	

	@NotNull(message="Last Name is a required field")
	@Size(min=1, max=16, message="Last Name must be between 1 and 16 characters")
	private String lastName;
	
	@NotNull(message="E-mail is a required field")
	@Size(min=1, max=32, message="E-mail must be between 1 and 32 characters")
	private String email;

	@NotNull(message="Mobile is a required field")
	private String mobile;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;

	@NotNull(message="Birthdate is a required field")
	private String birthdate;

	@NotNull(message="Gender is a required field")
	private boolean gender;
	private int role;
	
	public UserModel(int userID, String firstName, String lastName, String email, String mobile, String password,
			String birthdate, boolean gender, int role) {
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
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
