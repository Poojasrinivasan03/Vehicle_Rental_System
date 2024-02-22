package Vehical_System;
import java.util.*;
public class Bill {
	private double billamt;
	public void setBill(double t,String k,int h) {
		if(h>500) {
			t+=((t*15)/100);
		}
		if(k.equals("low")) {
			t+=((t*20)/100);
		}
		else if(k.equals("medium")) {
			t+=((t*50)/100);
		}
		else if(k.equals("high")) {
			t+=((t*75)/100);
		}
		billamt=t;
		
	}
	public double getBill() {
		return billamt;
	}
	
}

