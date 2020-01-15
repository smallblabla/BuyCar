package com.pfy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.pfy.DAO.JDBCDemo;
import com.pfy.bean.BuyThing;

public class UseDAO {
	
	public static void main(String args[]){
		
	}
	
	public static boolean getUser(String user,String password) {	
			com.pfy.bean.User A =  JDBCDemo.findByUser(user,password);
			System.out.println();
			System.out.println(A.getUser()+A.getPassword());
			System.out.println();
			System.out.println(user+password);
//			if(A.getUser() == user && A.getPassword() == password)
			if(A.getUser() != null)
				return true;
			else
				return false;		
	}
	
	public static List getThingList() {
		return JDBCDemo.findAll();
	}
	
	public static double PayAllMoney() {
		double sum = 0;
		List<BuyThing> Pay = new ArrayList();
		Pay = JDBCDemo.findAllBuyThing();
		for(int i=0 ; i<Pay.size() ; i++) {
			sum = sum + Pay.get(i).getNum()*Pay.get(i).getPrice();
		}
		return sum;
	}
}


