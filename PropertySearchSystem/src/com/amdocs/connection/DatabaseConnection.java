package com.amdocs.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	//for connection
	 public static Connection getConnection() { //compile time 
		Connection con=null;
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver"); //registration Connection string
			 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:xe","system","lion"); //connection
		 }catch(Exception e) {
			 System.out.println("error in connection");
		 }
		 return con;
	 }
}