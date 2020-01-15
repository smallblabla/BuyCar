package com.pfy.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pfy.bean.BuyThing;
import com.pfy.bean.Thing;
import com.pfy.bean.User;
import com.pfy.utls.GetMysql;

public class JDBCDemo {
	public static void main(String args[]){
		
	}
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	
	@SuppressWarnings("finally")
	public static User findByUser(String user,String password) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "select * from loginuser where user = ? and password = ?";
		ResultSet rs = null;
		User Anuser = new User();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				Anuser.setUser((String)rs.getString(2));
				Anuser.setPassword((String)rs.getString(3));
			}
			System.out.println("sql查找执行成功");
			return Anuser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql查找执行失败");
			e.printStackTrace();
		}finally {
			try {
				GetMysql.closeall(rs, stmt, conn);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
		
	public static boolean addThing(String name, double price, int num) {
		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "insert into things(name,price,num) values (?, ?, ?)";
		Thing thing = new Thing();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setDouble(2, price);
			ps.setInt(3, num);
			if(!ps.execute()) {
				System.out.println("数据保存成功");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据保存失败");
			e.printStackTrace();	
		}finally{
			try {
				GetMysql.closeall( null, stmt, conn);
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

	public static boolean addBuyThing(int id, String name, double price, int num) {
		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "insert into buything(id,name,price,num) values (?, ?, ?, ?)";
		Thing thing = new Thing();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setDouble(3, price);
			ps.setInt(4, num);
			if(!ps.execute()) {
				System.out.println("数据保存成功");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据保存失败");
			e.printStackTrace();	
		}finally{
			try {
				GetMysql.closeall( null, stmt, conn);
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public static List findAll() {

		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		ResultSet rs = null;
		String sql = "select * from things";
		List<Thing> allThing = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {		
				allThing.add(new Thing(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
			}
			System.out.println("查找成功");
			return allThing;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				GetMysql.closeall(rs, stmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List findAllBuyThing() {

		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		ResultSet rs = null;
		String sql = "select * from buything";
		List<BuyThing> allThing = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {		
				allThing.add(new BuyThing(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
			}
			System.out.println("查找成功");
			return allThing;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				GetMysql.closeall(rs, stmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static BuyThing findBuyThing(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "select * from buything where name = ?";
		ResultSet rs = null;
		BuyThing buything= new BuyThing();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				buything.setId(rs.getInt(1));
				buything.setName(rs.getString(2));
				buything.setPrice(rs.getDouble(3));
				buything.setNum(rs.getInt(4));	
				System.out.println("sql查找执行成功");
				return buything;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql查找执行失败");
			e.printStackTrace();
		}finally {
			try {
				GetMysql.closeall(rs, stmt, conn);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Thing findThing(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "select * from things where name = ?";
		ResultSet rs = null;
		Thing thing= new Thing();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				thing.setId(rs.getInt(1));
				thing.setName(rs.getString(2));
				thing.setPrice(rs.getDouble(3));
				thing.setNum(rs.getInt(4));	
				System.out.println("sql查找执行成功");
				return thing;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql查找执行失败");
			e.printStackTrace();
		}finally {
			try {
				GetMysql.closeall(rs, stmt, conn);
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
	
	public static void addBuyThingNum(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "update buything set num = num + 1 where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			if(ps.execute()) {
				System.out.print("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("添加失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}
	
	public static void subtractBuyThingNum(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "update buything set num = num - 1 where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			if(ps.execute()) {
				System.out.print("减少成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("减少失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}
	
	public static void addThingNum(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "update things set num = num + 1 where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			if(ps.execute()) {
				System.out.print("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("添加失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}

	public static void addThingNum(String name,int buynum) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "update things set num = num + ? where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, buynum);
			ps.setString(2, name);
			if(ps.execute()) {
				System.out.print("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("添加失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}
	
	public static void subtractThingNum(String name) {
	    conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "update things set num = num - 1 where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			if(ps.execute()) {
				System.out.print("减少成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("减少失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}

	public static void deleteThing(String name) {
		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "delete from buything where name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			if(ps.execute()) {
				System.out.print("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("删除失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}

	public static void deleteAllBuyThing() {
		conn = GetMysql.getConnection();
		stmt = GetMysql.getStatement();
		String sql = "delete from buything";
		try {
			ps = conn.prepareStatement(sql);
			if(ps.execute()) {
				System.out.print("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("删除失败");
			e.printStackTrace();
		}finally {
			GetMysql.closeall(null, stmt, conn);
		}
	}

	
}
	
