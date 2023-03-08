package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pdao{
	private static Pdao pdao = new Pdao();
	public static Pdao getInstance() {return pdao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Pdao() {
		try {
			//해당 mysql 드라이버 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean onWrite2(Pdto pdto) {
		String sql = "insert into q3(product,price) values(?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pdto.getProduct());
			ps.setInt(2, pdto.getPrice());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public ArrayList<Pdto> onPrint2() {
		ArrayList<Pdto> list = new ArrayList<>();
		String sql = "select * from q3;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Pdto pdto = new Pdto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(pdto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean onDelete2(int pno) {
		String sql = "delete from q3 where pno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public boolean onUpdate2(Pdto pdto) {
		String sql = "update q3 set product=? ,  price =? where pno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pdto.getProduct());
			ps.setInt(2, pdto.getPrice());
			ps.setInt(3, pdto.getPno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
}
