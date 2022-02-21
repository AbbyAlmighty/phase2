package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassRoom {
	
	public int cr(int cr) {
		
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phase2","root","1234");
			
			stmt=con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" ");
			
			ResultSet rs1 = stmt.executeQuery("select * from Teacher");
			while (rs1.next())
				System.out.println(rs1.getString(1) + "  " + rs1.getString(2));
			System.out.println(" ");
			
			System.out.print("From the above list, Enter EMPLOYEE ID of the Teacher you want to assign : ");
			String t = br.readLine();
			System.out.println(" ");
			
			ResultSet rs2 = stmt.executeQuery("select * from Class");
			while (rs2.next())
				System.out.println(rs2.getString(1) + "  " + rs2.getString(2));
			System.out.println(" ");
			
			System.out.print("From the above list, Enter CLASS ID you want to assign the Teacher to : ");
			String cID = br.readLine();
			System.out.println(" ");
			
			ResultSet rs3 = stmt.executeQuery("select * from Subject");
			while (rs3.next())
				System.out.println(rs3.getString(1) + "  " + rs3.getString(2));
			System.out.println(" ");
			
			System.out.print("From the above list, Enter SUBJECT ID which you want the Teacher to teach this class : ");
			String sID = br.readLine();
			
			stmt.execute("INSERT INTO Classroom (Emp_Id, Class_Id, Sub_Id)"+"VALUES ("+"'"+t+"'"+","+"'"+cID+"'"+","+"'"+sID+"'"+")");
			System.out.println("Assigned Successfully");
			
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
		
		return cr;
	}

}
