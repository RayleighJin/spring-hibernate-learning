package com.hao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pswd = "hbstudent";
		
		try {
			System.out.println("Connecting to Database: " + url);
			
			Connection myConnection = DriverManager.getConnection(url, user, pswd);
			
			System.out.println("Connection created successfully!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
