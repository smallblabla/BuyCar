package com.pfy.utls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetMysql {
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/buy_car";
	static String user = "root";
	static String password = "pfy19981012";
	static Connection conn = null;
	static Statement stmt = null;
	
	public static Connection getConnection(){	
		try {
			Class.forName(DRIVER);
			System.out.println("数据库驱动获取成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动获取失败");
			e.printStackTrace();
		}
		
		try {
			conn =  DriverManager.getConnection(url,user,password);
			System.out.println("连接数据库成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
		return conn;	
	}
	
	public static Statement getStatement( ) {
		try {
			stmt =  conn.createStatement();
			System.out.println("sql预编译成功");
			return stmt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql预编译失败");
			e.printStackTrace();
		}
		return stmt;	
	}
	
	public static void closeall(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null)
				rs.close();
			System.out.println("rs清除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("rs清除失败");
			e.printStackTrace();
		}
		
		try {
			if(stmt != null)
				stmt.close();
			System.out.println("stmt清除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("stmt清除失败");
			e.printStackTrace();
		}
		
		try {
			if(conn != null)
				conn.close();
			System.out.println("conn清除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conn清除失败");
			e.printStackTrace();
		}
		
		rs = null;
		stmt = null;
		conn = null;
		
	}
}
