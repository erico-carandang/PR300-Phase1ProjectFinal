package com.mvc.util;
 
import java.sql.Connection;
import java.sql.DriverManager;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
 
public class DBConnection {
 public static Connection createConnection()
 {
     Connection con = null;
      
  // Create a variable for the connection string.
     String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=a;databaseName=PR300-PracticumPhase1";

     try
     {
    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 con = DriverManager.getConnection(connectionUrl);
    	 System.out.println("Printing connection object "+con);
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }   
     return con; 
 }
}