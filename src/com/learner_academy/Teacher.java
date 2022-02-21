package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Teacher {
	
	public int teacher(int t) {
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter Employee Id : ");
			String emp_id = br.readLine();
			
			System.out.print("Enter Name of Teacher : ");
			String name = br.readLine();
			
			stmt.execute("INSERT INTO Teacher (Emp_Id, Name)"+"VALUES ("+"'"+emp_id+"'"+","+"'"+name+"'"+")");
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
		return t;
		
	}

}
