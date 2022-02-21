package com.learner_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
	void welcome() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Welcome to LEARNER'S ACADEMY");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Developed by - Abhishek Tiwari");
		System.out.println(" ");
		System.out.println(" ");
		Lobby l = new Lobby();
		l.lobby(0);
		}
	private int log(int x){
		String user = "admin";
		String pword = "1234";
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Username : ");
		String uname = in.readLine();
		System.out.print("Enter Password : ");
		String pass = in.readLine();
		if (uname.equals(user) && pass.equals(pword)) {
			Login w = new Login();
			w.welcome();
		} else {
			System.out.println ("Wrong Username or Password !!");
			System.out.println(" ");
			Login v = new Login();
			v.log(0);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}return x;
	}
	
	public static void main(String args[]) {
		Login login = new Login();
		login.log(0);
	}
}
