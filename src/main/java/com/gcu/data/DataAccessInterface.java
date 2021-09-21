package com.gcu.data;

import java.util.List;

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
 * 1. Interface - Data Access - Main 
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

public interface DataAccessInterface <T> {
	
	/**
	 * Generic Method to find a list of all specified items
	 * @return list of specified objects
	 */
	public List<T> findAll();
	
	/**
	 * Generic Method to find a specified object by id
	 * @param id - id to search
	 * @return specified object or null if not found
	 */
	public T findById(int id);
	
	/**
	 * Generic Method to create/store object in database
	 * @param t - specified object
	 * @return boolean - true if successfully created, false otherwise
	 */
	public boolean create(T t);
	
	/**
	 * Generic Method to update object in database
	 * @param t - specified object
	 * @return boolean - true if successfully updated, false otherwise
	 */
	public boolean update(T t);
	
	/**
	 * Generic Method to delete object from database
	 * @param id - specified item to delete/update deleted flag
	 * @return boolean - true is successfully deleted, false otherwise
	 */
	public boolean delete(String id);
}
