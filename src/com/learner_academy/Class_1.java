package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Class_1 {
	
	public int cls(int c) {
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter Class Id : ");
			String cls_id = br.readLine();
			
			System.out.print("Enter Class Name : ");
			String cls_name = br.readLine();
			
			stmt.execute("INSERT INTO Class (Class_Id, Class_Name)"+"VALUES ("+"'"+cls_id+"'"+","+"'"+cls_name+"'"+")");
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
		return c;
		
	}
}
