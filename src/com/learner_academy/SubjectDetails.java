package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SubjectDetails {
	
	public int sdet(int s) {
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" ");
			ResultSet rs1 = stmt.executeQuery("select * from Class");
			while (rs1.next())
				System.out.println(rs1.getString(1) + "  " + rs1.getString(2));
			System.out.println(" ");
			
			System.out.print("From the above list, Enter CLASS ID you want to assign Subject for : ");
			String cID = br.readLine();
			System.out.println(" ");
			
			ResultSet rs2 = stmt.executeQuery("select * from Subject");
			while (rs2.next())
				System.out.println(rs2.getString(1) + "  " + rs2.getString(2));
			System.out.println(" ");
			
			System.out.print("From the above list, Enter SUBJECT ID you want to assign for this class : ");
			String sID = br.readLine();
			
			stmt.execute("INSERT INTO Subject_Details (Class_Id, Sub_Id)"+"VALUES ("+"'"+cID+"'"+","+"'"+sID+"'"+")");
			System.out.println("Assigned Successfully.");
			
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
