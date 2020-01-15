package com.pfy.service;

import java.util.ArrayList;
import java.util.List;

import com.pfy.DAO.JDBCDemo;
import com.pfy.bean.BuyThing;
import com.pfy.bean.Thing;

public class AddThing {
	
	public static void main(String args[]){
	
	}
	
	public static boolean addThing(String name) {
		if(JDBCDemo.findBuyThing(name) != null) return true;
		else return false;
	}
	
	public static void addBuyThing(String name) {
		Thing Thing = new Thing();
		Thing = JDBCDemo.findThing(name);
		JDBCDemo.addBuyThing(Thing.getId(),Thing.getName(),Thing.getPrice(),1);
		JDBCDemo.subtractThingNum(name);
	}
	
	public static void addBuyThingNum(String name) {
		JDBCDemo.addBuyThingNum(name);
		JDBCDemo.subtractThingNum(name);
	}
	
	public static List findAllBuyThing() {
		return(JDBCDemo.findAllBuyThing());
	}

	public static void subtractBuything(String name) {
		if(JDBCDemo.findBuyThing(name).getNum() == 0) {
			deleteBuyThing(name);
		}
		JDBCDemo.subtractBuyThingNum(name);
		JDBCDemo.addThingNum(name);
	}

	public static void deleteBuyThing(String name) {
		int num = JDBCDemo.findBuyThing(name).getNum();
		JDBCDemo.deleteThing(name);
		JDBCDemo.addThingNum(name, num);
	}
	
	public static void deleteAllBuyThing() {
		JDBCDemo.deleteAllBuyThing();
	}
}

