package Vehical_System;
import java.util.*;
import java.sql.*;
import java.util.Random;
public class Admin {
	public static void addOne(String name,double t) {
		Random random = new Random();
        int randomInteger = random.nextInt();
        SecurityDeposit.addDep(randomInteger,name,t);
	}
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int choice=0;
	do {
		System.out.println();
		System.out.println("");
		System.out.println("*********************************************************************************************************************************************");
		System.out.println();
		System.out.println("");
		System.out.println("Enter 1 to add vehicle");
	System.out.println("Enter 2 to view Vehice");
	System.out.println("Enter 3 to search Vehicle");
	System.out.println("Enter 4 to view Vehicles to Service");
	System.out.println("Enter 5 to modify");
	System.out.println("Enter 6 to add and modify Security deposit");
	System.out.println("Enter 9 to exit");System.out.println();
	System.out.println("");
	System.out.println("*********************************************************************************************************************************************");

	choice=sc.nextInt();
	if(choice==1) {
	
		System.out.println("Enter 1 for car 2 for bike");
		int c1=sc.nextInt();
		sc.nextLine();
		if(c1==1) {
			System.out.println("Enter Car name");
			String n=sc.next();
			System.out.println("Enter Number plate");
			String npl=sc.next();
			System.out.println("Enter count ");
			int co=sc.nextInt();
			System.out.println("Enter price");
			double p=sc.nextDouble();
			System.out.println("Enter rented count");
			int r=sc.nextInt();
			System.out.println("Enter total kms ");
			double km=sc.nextDouble();
			Car.addCar(n,npl,co, p, r, km);
		}
		if(c1==2) {
			System.out.println("Enter Bike name");
			String n=sc.nextLine();
			System.out.println("Enter Number plate");
			String npl=sc.next();
			System.out.println("Enter count ");
			int co=sc.nextInt();
			System.out.println("Enter price");
			double p=sc.nextDouble();
			System.out.println("Enter rented count");
			int r=sc.nextInt();
			System.out.println("Enter total kms ");
			double km=sc.nextDouble();
			Bike.addBike(n,npl,co, p, r, km);
		}
	}
	else if(choice==2) {
		Vehicle.viewVehicle();
	}
	else if(choice==3) {
		System.out.println("Enter number plate number");
		String num=sc.next();
		Vehicle.searchVehicle(num);
	}
	else if(choice==4) {
		Vehicle.service();
	}
	else if(choice==5) {
		System.out.println("Enter 1 to modify available count 2 to delete vehicle");
		int mod=sc.nextInt();
		if(mod==1) {
			System.out.println("Enter vehicle name and count");
			String veh=sc.next();
			int cou=sc.nextInt();
			Vehicle.countModify(veh,cou);
		}
		if(mod==2) {
			System.out.println("Enter numberplate number to delete vehicle");
			String ve=sc.next();
			Vehicle.delete(ve);
		}
	}
	else if(choice==6) {
		System.out.println("Enter 1 to add 2 to view ");
		int h1=sc.nextInt();
		if(h1==1) {
			System.out.println("Enter name of customer");
			String n=sc.next();
			System.out.println("Enter amount");
			double smt=sc.nextDouble();

	        Random random = new Random();
	        int randomInteger = random.nextInt();
	        SecurityDeposit.addDep(randomInteger, n, smt);
			
		}
		if(h1==2) {
			SecurityDeposit.viewsd();
		}
	}
	
	}while(choice!=9);

	
}
public static void payBill(int id,String name,double amt) {
	try {
		Connections conn=new Connections();
		Connection connection=conn.connect(); 
		try(Statement st=connection.createStatement()){
			String q1="INSERT INTO bill values('"+id+"','"+name+"','"+amt+"')";
			int r=st.executeUpdate(q1);
			if(r>0) {
				System.out.println("Paid sucessfully");
			}
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
