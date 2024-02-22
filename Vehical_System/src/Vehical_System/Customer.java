package Vehical_System;
import java.util.*;
import java.sql.*;
public class Customer {
	private String customer_id;
	private String customer_name;
	private String customer_address;
	private String contact_no;
	private String rationcard_no;
	public Customer(String id,String name,String address,String no,String r_no) {
		 customer_id=id;
		 customer_name=name;
		 customer_address=address;
		 contact_no=no;
		 rationcard_no=r_no;
	}
	public void setid(String id) {
		customer_id=id;
	}
	public String getid() {
		return customer_id;
	}
	public void setname(String name) {
		customer_name=name;
	}
	public String getname() {
		return customer_name;
	}
	public void setaddress(String add) {
		customer_address=add;
	}
	public String getaddress() {
		return customer_address;
	}
	public void setno(String no) {
		contact_no=no;
	}
	public String getno() {
		return contact_no;
	}
	public void setcardno(String cno) {
		rationcard_no=cno;
	}
	public String getcardno() {
		return rationcard_no;
	}
}
