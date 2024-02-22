package Vehical_System;
import java.util.*;
import java.sql.*;
public class SecurityDeposit {
	
	public static void addDep(int id,String name , double amt) {
		try {
			Connections conn = new Connections();
			Connection connection = conn.connect();
			try(Statement statement = connection.createStatement()){
				String q1="Insert into securitydeposit values('"+id+"','"+name+"','"+amt+"');";
				int r=statement.executeUpdate(q1);
				if(r>0) {
					System.out.println("successfull");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void viewsd(){
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="select * from securitydeposit";
			ResultSet rs=statement.executeQuery(q1);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+" 	"+rs.getDouble(3));
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}}
}
