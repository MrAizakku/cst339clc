package com.gcu.models;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group Purple
 * Members   : D. Johnson, I Tucker, I. Debenedetto, K. Kubli, K. Lamb
 * Date      : 2021-08-14
 * Class     : CST-339 Java Programming III
 * Professor : Brandom Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Data Model - Category
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 Team                Initial Creation
 *
 *
 */

public class CategoryModel {
	private int ID;
	private String categoryName;
	
	/**
	 * Non-Default Constructor
	 * @param iD - id (key)
	 * @param categoryName - name of category
	 */
	public CategoryModel(int iD, String categoryName) {
		super();
		ID = iD;
		this.categoryName = categoryName;
	}

	/**
	 * Get the id for the category
	 * @return Category id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set the category id
	 * @param iD - id (key)
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get the category name
	 * @return Category Name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Set the name of Category
	 * @param categoryName - name of category
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
