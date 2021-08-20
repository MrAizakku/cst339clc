package com.gcu.models;

import java.util.Date;
import java.util.List;

public class PostModel {
	private int ID;
	private String title;
	private String content;
	private CategoryModel category;
	private Date date;
	private UserModel author;
	private Date updatedDate;
	private UserModel updatedBy;
	private List<RatingModel> ratingScore;
	private String keywords;
	private List<CommentModel> comments;
	
	public PostModel(int iD, String title, String content, CategoryModel category, Date date, UserModel author, Date updatedDate,
			UserModel updatedBy, List<RatingModel> ratingScore, String keywords, List<CommentModel> comments) {
		super();
		ID = iD;
		this.title = title;
		this.content = content;
		this.category = category;
		this.date = date;
		this.author = author;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.ratingScore = ratingScore;
		this.keywords = keywords;
		this.comments = comments;
	}

	public PostModel() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserModel getAuthor() {
		return author;
	}

	public void setAuthor(UserModel author) {
		this.author = author;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserModel getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UserModel updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<RatingModel> getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(List<RatingModel> ratingScore) {
		this.ratingScore = ratingScore;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<CommentModel> getComments() {
		return comments;
	}

	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
