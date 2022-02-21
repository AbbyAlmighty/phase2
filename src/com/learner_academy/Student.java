package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {
	
	public int student(int s) {
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter Roll No. : ");
			String roll = br.readLine();
			
			System.out.print("Enter Name of Student : ");
			String name = br.readLine();
			
			System.out.print("Enter The Class ID He/She Belongs To : ");
			String cls = br.readLine();
			
			stmt.execute("INSERT INTO Student (Roll_No, Name, Class_Id)"+"VALUES ("+"'"+roll+"'"+","+"'"+name+"'"+","+"'"+cls+"'"+")");
			System.out.println("Records Inserted");
			
			con.close();
			MenuOp m = new MenuOp();
			m.menu(0);
		}catch(Exception e) { 
			e.printStackTrace(); }
		
		finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
		
	}

}
