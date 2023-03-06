package practice.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			//해당 mysql 드라이버 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean setData(String data) {
		String sql = "insert into ex1(e_data) values(?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public ArrayList<String> getData() {
		ArrayList<String> list = new ArrayList();
		String sql = "select * from ex1;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean setData2(String data) {
		String sql = "insert into q1(q_data) values(?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public ArrayList<String> getData2() {
		ArrayList<String> list = new ArrayList();
		String sql = "select * from q1;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	
	
	
}
