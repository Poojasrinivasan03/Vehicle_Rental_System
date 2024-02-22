package Vehical_System;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

public class Borrower {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Cart>cart=new ArrayList<>();
		int ch=0;
		do {
			System.out.println();
			System.out.println("");
			System.out.println("****************************************************************************************************************************************************");
			System.out.println();
			System.out.println("");
			System.out.println("Enter 1 to view vehicles");
		System.out.println("Enter 2 to Rent Vehicle");
		System.out.println("Enter 3 to Pay Amount");
		System.out.println("Enter 4 to get bill");
		//System.out.println("Enter 5 to pay bill");
		System.out.println("Enter 9 to exit");

		System.out.println();
		System.out.println("");
		System.out.println("****************************************************************************************************************************************************");

		System.out.println();
		System.out.println("");
		ch=sc.nextInt();
		if(ch==1) {
			Vehicle.viewVehicle();
		}
		else if(ch==2) {
			System.out.println("Select Vehicle");
			Vehicle.viewVehicle();
			System.out.println("Enter Vehicle number plate to select vehicle");
			String sel=sc.next();
			LocalDate d=LocalDate.now();
			String name="";
			Double price=0.0;
			Cart c=new Cart();
			try {
				Connections conn=new Connections();
				Connection connection=conn.connect();
				try(Statement statement=connection.createStatement()){
					String q1="select name,price from vehicle where numberplate='"+sel+"'";
					ResultSet rs=statement.executeQuery(q1);
					while(rs.next()) {
						name=rs.getString(1);
						price=rs.getDouble(2);
					}
					
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}

			c.addCart(name, sel, price, d, cart);
			System.out.println("Items in cart"+"/n"+cart);
			for(Cart al:cart) {
				System.out.println(al);
			}
			Vehicle.delete(sel);
			}

		else if(ch==3) {
			System.out.println("Enter name and amount to be paid");
			String name=sc.next();
			double pri=sc.nextDouble();
			Admin.addOne(name, pri);
		}
		else if(ch==4) {
			Bill b=new Bill();
			//double l=0.0;
			Double price=0.0;
			System.out.println("Enter numberplate");
			String sel=sc.next();
			try {
				Connections conn=new Connections();
				Connection connection=conn.connect();
				try(Statement statement=connection.createStatement()){
					String q1="select price from vehicle where numberplate='"+sel+"'";
					System.out.println("Query: " + q1); 
					ResultSet rs=statement.executeQuery(q1);
					while(rs.next()) {
						//name=rs.getString(1);
						price=rs.getDouble(1);
					}
					
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}

			System.out.println("Enter damage rate");
			System.out.println("low / medium / high ");
			String m=sc.next();
			System.out.println("Enter kms ");
			int h=sc.nextInt();
			b.setBill(price, m,h);
			System.out.println(b.getBill());//.getBill();
			System.out.println("Enter 1 to pay bill 2 to exit");
			int u=sc.nextInt();
			if(u==1) {
				double bi=b.getBill();
				System.out.println("Enter name");
				String name=sc.next();
				Random random = new Random();
		        int randomInteger = random.nextInt();
				Admin.payBill(randomInteger,name,bi);
			}
			else {
				break;
			}
		}
		
		}while(ch!=9);
}
}