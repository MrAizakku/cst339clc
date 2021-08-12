package com.gcu.models;

public class CategoryModel {
	private int ID;
	private String categoryName;
	
	public CategoryModel(int iD, String categoryName) {
		super();
		ID = iD;
		this.categoryName = categoryName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
