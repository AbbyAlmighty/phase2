package com.learner_academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuOp {
	public int menu(int x) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter 1 to insert Subject details");
			System.out.println("Enter 2 to insert Class details");
			System.out.println("Enter 3 to insert Teacher details");
			System.out.println("Enter 4 to insert Student details");
			System.out.println("Enter 5 to Assign Classes for Subject");
			System.out.println("Enter 6 to Assign Teacher to a Class for a Subject");
			System.out.println("Enter 7 to view Class Report");
			System.out.println("Enter 8 to Exit Application");
			System.out.println(" ");
			System.out.print("Enter your choice to continue : ");
			int input = Integer.parseInt(br.readLine());
			
			switch (input) {
			
			case 1: Subject s = new Subject();
					s.sub(0);
					break;
			case 2: Class_1 c = new Class_1();
					c.cls(0);
					break;
			case 3: Teacher t = new Teacher();
					t.teacher(0);
					break;
			case 4: Student st = new Student();
					st.student(0);
					break;
			case 5: SubjectDetails sd = new SubjectDetails();
					sd.sdet(0);
					break;
			case 6: ClassRoom cr = new ClassRoom();
					cr.cr(0);
					break;
			case 7: Report r = new Report();
					r.report(0);
					break;
			case 8: System.out.println("Goodbye !!");
					break;
			default: System.out.println("Invalid Choice. Try Again.");
					MenuOp m = new MenuOp();
					m.menu(0);
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}

}
