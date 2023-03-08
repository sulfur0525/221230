package practice.day03;

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
	
	public boolean onWrite(Dto dto) {
		String sql ="insert into ex3(bcontent,bwriter) values(?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public ArrayList<Dto> onPrint(){
		ArrayList<Dto> list = new ArrayList<>();
		String sql = "select * from ex3;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}return list;
		
	}
	
	public boolean onDelete(int bno) {
		String sql = "delete from ex3 where bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public boolean onUpdate(Dto dto) {
		String sql = "update ex3 set bcontent = ? where bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(2, dto.getBno());
			ps.setString(1, dto.getBcontent());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
}
