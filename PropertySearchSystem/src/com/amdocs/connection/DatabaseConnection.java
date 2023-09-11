package com.amdocs.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	//for connection
	 public static Connection getConnection() {
		Connection con=null;
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver"); //registration
			 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:xe","system","lion"); //connection
		 }catch(Exception e) {
			 System.out.println("error in connection");
		 }
		 return con;
	 }

	public static void closeConnection() {
		// TODO Auto-generated method stub
		
	}
}