package Vehical_System;
import java.time.LocalDate;
import java.util.*;
public class Cart {
	String name;
	String numberplate;
	Double price;
	LocalDate date;//=LocalDate.now();
	static int c=0;
	Cart(){
		
	}
	Cart(String name,String numberplate,Double price,LocalDate date){
		this.name=name;
		this.numberplate=numberplate;
		this.price=price;
		this.date=date;
		c++;
		System.out.println(c);
	}
	
	public ArrayList<Cart> addCart(String name,String numberplate,Double price,LocalDate date,ArrayList<Cart> cart) {
		
		Cart c1=new Cart(name,numberplate,price,date);
		System.out.println("-----------------------------");
		if(c<=1) {
		cart.add(c1);
		System.out.println(c1.name+" "+c1.numberplate+" "+c1.price+" "+c1.date);
		System.out.println(cart);
		return cart;
	}
		else {
			System.out.println("limit reached");
			return cart;
		}
	}
}
