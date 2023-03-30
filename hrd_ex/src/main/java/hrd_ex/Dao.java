package hrd_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	
	public static Connection con;
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static Connection getConnection() throws Exception{
		//해당 mysql 드라이버 찾기
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe","root","1234");
		System.out.println("연동성공");
		return con;
	}
	
	public Dao() {
		try {
			con = getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public int getcustno() {
		String sql = "select max(custno)+1 from member_tbl_02;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}return 0;
	}
	
	public boolean join(MemberDto dto) {
		String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setString(7, dto.getCity());
			int cnt = ps.executeUpdate();
			if(cnt==1) return true;
		} catch (Exception e) {
			System.out.println(e);
		} return false;
	}
	
	public ArrayList<MemberDto> getmemeberlist() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member_tbl_02 ;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7),0);
				
				list.add(dto);
			}return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public ArrayList<MemberDto> getsum() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select DISTINCT me.custno, me.custname, me.grade , "
				+ "(select sum(price) from money_tbl_02 mo where mo.custno = me.custno) as sum "
				+ "from member_tbl_02 me natural join money_tbl_02 mo order by sum desc;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(dto);
			}return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public MemberDto getmember(int custno) {
		String sql = "select * from member_tbl_02 where custno="+custno+";";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7),0);
				return dto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean update(MemberDto dto) {
		String sql = "update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCustname());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getJoindate());
			ps.setString(5, dto.getGrade());
			ps.setString(6, dto.getCity());
			ps.setInt(7, dto.getCustno());
			int cnt = ps.executeUpdate();
			if(cnt==1) return true;
		} catch (Exception e) {
			System.out.println(e);
		} return false;
		
	}
}
