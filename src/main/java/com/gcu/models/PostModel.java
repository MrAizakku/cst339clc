package com.gcu.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostModel {
	private int ID;

	@NotNull(message="Blog Title is a required field")
	@Size(min=1, max=100, message="Blog title must be between 1 and 100 characters")
	private String title;
	
	@NotNull(message="Blog Content is a required field")
	@Size(min=1, max=65535, message="Blog content must be between 1 and 65535 characters")
	private String content;

	private CategoryModel category;
	private Date date;
	private int authorID;
	private String authorName;
	private Date updatedDate;
	private int updatedBy;
	private List<RatingModel> ratingScore;

	@Size(max=128, message="Keywords cannot exceed 128 characters")
	private String keywords;
	private List<CommentModel> comments;
	
	public PostModel(int iD, String title, String content, CategoryModel category, Date date, int authorID, String authorName, Date updatedDate,
			int updatedBy, List<RatingModel> ratingScore, String keywords, List<CommentModel> comments) {
		super();
		ID = iD;
		this.title = title;
		this.content = content;
		this.category = category;
		this.date = date;
		this.authorID = authorID;
		this.authorName = authorName;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.ratingScore = ratingScore;
		this.keywords = keywords;
		this.comments = comments;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int author) {
		this.authorID = author;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
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
