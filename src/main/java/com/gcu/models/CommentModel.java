package com.gcu.models;

import java.util.Date;

import javax.validation.constraints.Size;

public class CommentModel {
	private int ID;
	private int commentPostID;
	private UserModel commentBy;
	private Date commentDate;

	@Size(min=0, max=128, message="Comment cannot exceed 500 characters")
	private String commentText;
	
	public CommentModel(int commentID, int commentPostID, UserModel commentBy, Date commentDate, String commentText) {
		super();
		this.ID = commentID;
		this.commentPostID = commentPostID;
		this.commentBy = commentBy;
		this.commentDate = commentDate;
		this.commentText = commentText;
	}

	public CommentModel() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentID() {
		return ID;
	}

	public void setCommentID(int commentID) {
		this.ID = commentID;
	}

	public int getCommentPostID() {
		return commentPostID;
	}

	public void setCommentPostID(int commentPostID) {
		this.commentPostID = commentPostID;
	}

	public UserModel getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(UserModel commentBy) {
		this.commentBy = commentBy;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
}
