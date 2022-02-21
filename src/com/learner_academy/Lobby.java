package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lobby {
	
	public int lobby(int l) {
		
		Statement stmt = null;
		
		try {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("If you are new then create database 'phase2' in MySQL and press 1 to setup other requirements.");
		System.out.println("Press 2 if already done with this step.");
		System.out.print("Enter Choice : ");
		int input = Integer.parseInt(br.readLine());
		
		if (input == 1) {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			stmt.execute("DROP TABLE IF EXISTS Subject");
			stmt.execute("CREATE TABLE Subject(Sub_Id varchar(50) PRIMARY KEY, Sub_Name varchar(50))");
			
			stmt.execute("DROP TABLE IF EXISTS Class");
			stmt.execute("CREATE TABLE Class(Class_Id varchar(50) PRIMARY KEY, Class_Name varchar(10))");
			
			stmt.execute("DROP TABLE IF EXISTS Teacher");
			stmt.execute("CREATE TABLE Teacher(Emp_Id varchar(50) PRIMARY KEY, Name varchar(100))");
			
			stmt.execute("DROP TABLE IF EXISTS Student");
			stmt.execute("CREATE TABLE Student(Roll_No varchar(50) PRIMARY KEY, Name varchar(100), Class_Id varchar(10))");
			
			stmt.execute("DROP TABLE IF EXISTS Classroom");
			stmt.execute("CREATE TABLE Classroom(Emp_Id varchar(50), Class_Id varchar(50), Sub_Id varchar(50))");
			
			stmt.execute("DROP TABLE IF EXISTS Subject_Details");
			stmt.execute("CREATE TABLE Subject_Details(Class_Id varchar(50), Sub_Id varchar(50))");
			
			System.out.println("Setup Complete.");
			con.close();
			MenuOp m = new MenuOp();
			m.menu(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} else if (input == 2) {
			System.out.println("Welcome Back.");
			System.out.println(" ");
			System.out.println(" ");
			MenuOp m = new MenuOp();
			m.menu(0);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} return l;
	}

}
