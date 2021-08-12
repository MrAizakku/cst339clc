package com.gcu.models;

public class RatingModel {
	private int ID;
	private int ratingPostID;
	private UserModel ratedBy;
	private boolean ratingValue;
	
	public RatingModel(int ratingID, int ratingPostID, UserModel ratedBy, boolean ratingValue) {
		super();
		this.ID = ratingID;
		this.ratingPostID = ratingPostID;
		this.ratedBy = ratedBy;
		this.ratingValue = ratingValue;
	}

	public int getRatingID() {
		return ID;
	}

	public void setRatingID(int ratingID) {
		this.ID = ratingID;
	}

	public int getRatingPostID() {
		return ratingPostID;
	}

	public void setRatingPostID(int ratingPostID) {
		this.ratingPostID = ratingPostID;
	}

	public UserModel getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(UserModel ratedBy) {
		this.ratedBy = ratedBy;
	}

	public boolean isRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(boolean ratingValue) {
		this.ratingValue = ratingValue;
	}
}
