package com.gcu.database;


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
 * 1. Define database connection parameters
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 K. Lamb             Initial Creation
 *
 *
 */

public interface IConnectString
{

    String CONNECT_CLASS = "com.mysql.cj.jdbc.Driver";
    String DBURL = "jdbc:mysql://localhost:3306/cst_339";
    String DBBLOG = "root";
    String DBPASS = "root";
}