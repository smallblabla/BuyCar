package com.pfy.bean;

public class Thing {
	private int id;
	private String name;
	private double price;
	private int num;

	public Thing(int id, String name, double price, int num) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public Thing() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
