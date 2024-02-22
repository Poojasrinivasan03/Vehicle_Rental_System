package Vehical_System;
import java.util.*;
import java.sql.*;
public class Vehical_system_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME");
		System.out.println("Select choice");
		System.out.println("Enter 1 for Admin");
		System.out.println("Enter 2 for Borrower");
		int choose=sc.nextInt();
		if(choose==1) {
			System.out.println("Enter 1 for Admin login");
			System.out.println("Enter 2 for Admin signin");
			int c=sc.nextInt();
			if(c==2) {
				System.out.println("Enter user name");
				String name=sc.next();
				System.out.println("Enter email id");
				String mail=sc.next();
				System.out.println("Enter Password");
				String password=sc.next();
				try {
					Connections conn=new Connections();
					Connection connection=conn.connect();
					try(Statement statement = connection.createStatement()){
						String q1="Insert into admin values('"+name+"','"+mail+"','"+password+"');";
						int r=statement.executeUpdate(q1);
						if(r>0) {
							System.out.println("Successfull");
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
			else if(c==1) {
				System.out.println("Enter user name");
				String name=sc.next();
				System.out.println("Enter email id");
				String mail=sc.next();
				System.out.println("Enter password");
				String password=sc.next();
				try {
					Connections conn=new Connections();
					Connection connection=conn.connect();
					String q1="SELECT * FROM admin WHERE username='"+name+"' AND email = '"+mail+"' AND password='"+password+"';";
					try(Statement statement = connection.createStatement();){
						ResultSet resultset=statement.executeQuery(q1);
						if(resultset.next()==true) {
							System.out.println("*****************************************************WELCOME Admin "+name+" *******************************************************");
							Admin.main(null);
						}
						else {
							System.out.println("Invalid Details");
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		else if(choose==2) {
			System.out.println("Enter 1 for Borrower login");
			System.out.println("Enter 2 for Borrower signin");
			int c=sc.nextInt();
			if(c==2) {
				System.out.println("Enter user name");
				String name=sc.next();
				System.out.println("Enter email id");
				String mail=sc.next();
				System.out.println("Enter Password");
				String password=sc.next();
				try {
					Connections conn=new Connections();
					Connection connection=conn.connect();
					try(Statement statement = connection.createStatement()){
						String q1="Insert into borrower values('"+name+"','"+mail+"','"+password+"');";
						int r=statement.executeUpdate(q1);
						if(r>0) {
							System.out.println("Successfull");
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
			else if(c==1) {
				System.out.println("Enter user name");
				String name=sc.next();
				System.out.println("Enter email id");
				String mail=sc.next();
				System.out.println("Enter password");
				String password=sc.next();
				try {
					Connections conn=new Connections();
					Connection connection=conn.connect();
					String q1="SELECT * FROM borrower WHERE username='"+name+"' AND email = '"+mail+"' AND password='"+password+"';";
					try(Statement statement = connection.createStatement();){
						ResultSet resultset=statement.executeQuery(q1);
						if(resultset.next()==true) {
							System.out.println("*******************************WELCOME "+name+" *********************************************");
						}
						else{
							System.out.println("Invalid Details");
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		else {
			System.out.println("Invalid Input");
		}

	}

}
