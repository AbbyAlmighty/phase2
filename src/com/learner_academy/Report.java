package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Report {
	
	public int report(int r) {
		
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
			
			System.out.print("From the above list, Enter CLASS ID you want to see the report for : ");
			String cID = br.readLine();
			System.out.println(" ");
			
			ResultSet rs2 = stmt.executeQuery("select * from Class,Student,Teacher,Subject,Classroom where "
					+ "Class.Class_Id=Student.Class_Id and Class.Class_Id=Classroom.Class_Id and "
					+ "Classroom.Emp_Id=Teacher.Emp_Id and Classroom.Sub_Id=Subject.Sub_Id and "
					+ "Class.Class_Id="+"'"+cID+"'");
			while (rs2.next())
				System.out.println(rs2.getString(1) + "  " + rs2.getString(2)+ "  " + rs2.getString(3)
				+ "  " + rs2.getString(4)+ "  " + rs2.getString(5)+ "  " + rs2.getString(6)+ "  " + rs2.getString(7)
				+ "  " + rs2.getString(8)+ "  " + rs2.getString(9)+ "  " + rs2.getString(10));
			System.out.println(" ");
			System.out.println(" ");
			
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
		
		return r;
	}

}
