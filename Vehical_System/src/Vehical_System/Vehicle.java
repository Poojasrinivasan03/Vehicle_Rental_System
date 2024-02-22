package Vehical_System;
import java.sql.*;
public class Vehicle {
	String vname;
	String numberplate;
	int vcount;
	double vprice;
	int rcount;
	double kms;
	Vehicle(String vname,String numberplate,int vcount,double vprice,int rcount,double kms){
		this.vname=vname;
		this.numberplate=numberplate;
		this.vcount=vcount;
		this.vprice=vprice;
		this.rcount=rcount;
		this.kms=kms;
	}

public static void viewVehicle() {
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="select * from vehicle";
			ResultSet rs=statement.executeQuery(q1);
			while(rs.next()) {
				System.out.println(rs.getString(1)+"	"+rs.getString(2)+" 	"+rs.getInt(3)+"    "+rs.getDouble(4)+"		"+rs.getInt(5)+"	"+rs.getDouble(6));
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public static void searchVehicle(String np) {
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="select * from vehicle where numberplate='"+np+"'";
			ResultSet rs=statement.executeQuery(q1);
			while(rs.next()==true) {
				System.out.println("Vehicle available");
				//System.out.println(rs.getString(1)+"	"+rs.getString(2)+"		"+rs.getDouble(3)+"		"+rs.getInt(4)+"	"+rs.getDouble(5));
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public static void service() {
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="select name,numberplate,price,rentedcount,km from vehicle where km>=3000 && price>=3000";
			ResultSet rs=statement.executeQuery(q1);
			while(rs.next()) {
				System.out.println(rs.getString(1)+"	"+rs.getString(2)+"		"+rs.getDouble(3)+"		"+rs.getInt(4)+"	"+rs.getDouble(5));
			}
			String q2="select name,numberplate,price,rentedcount,km from vehicle where km>=1500 && price<=3000";
			ResultSet r=statement.executeQuery(q2);
			while(r.next()) {
				System.out.println(r.getString(1)+"	"+r.getString(2)+"		"+r.getDouble(3)+"		"+r.getInt(4)+"	   "+r.getDouble(5));
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public static void countModify(String v,int c) {
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect();
		try(Statement statement=connection.createStatement()){
			String q1="UPDATE vehicle SET count = '"+c+"' WHERE name = '"+v+"';";
			int rs=statement.executeUpdate(q1);
			if(rs>0) {
				System.out.println("Update Succesfull");
			}
			
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
public static void delete(String numberPlate) {
    try {
        Connections conn = new Connections();
        Connection connection = conn.connect();
        try (Statement statement = connection.createStatement()) {
            String deleteQuery = "DELETE FROM vehicle WHERE numberplate = '" + numberPlate + "'";
            int rowsAffected = statement.executeUpdate(deleteQuery);
            String s1="UPDATE vehicle SET count=count-1 WHERE numberplate='"+numberPlate+"'";
            int k2=statement.executeUpdate(s1);
            if (rowsAffected > 0) {
                System.out.println("Successfull.");
            } else {
                System.out.println("No rows found for the given numberplate number.");
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

}
class Car extends Vehicle{
	Car(String name,String np,int count,double price,int rc,double km){
		super(name,np,count,price,rc,km);
	}
	public static void addCar(String name,String np,int count,double price,int rc,double km) {
		try {
			Connections conn = new Connections();
			Connection connection = conn.connect();
			try(Statement statement = connection.createStatement()){
				String q1="Insert into vehicle values('"+name+"','"+np+"','"+count+"','"+price+"','"+rc+"','"+km+"');";
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
	
}
class Bike extends Vehicle{
	Bike(String name,String np,int count,double price,int rc,double km){
		super(name,np,count,price,rc,km);
	}
	public static void addBike(String name,String np,int count,double price,int rc,double km) {
		try {
			Connections conn = new Connections();
			Connection connection = conn.connect();
			try(Statement statement = connection.createStatement()){
				String q1="Insert into vehicle values('"+name+"','"+np+"','"+count+"','"+price+"','"+rc+"','"+km+"');";
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
	
	
}
	
	

