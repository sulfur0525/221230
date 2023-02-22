package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class MemberDao {
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	
	private MemberDao() {
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15","root","1234");
				System.out.println("[ 연동 성공 ]");
		} catch (Exception e) {	System.out.println(e.getMessage());}
	}
	
	//등록
	public boolean singup(MemberDto dto) {
		String sql = "insert into member(mid,mpw) values(? ,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {	
			System.out.println("DB오류"+e);
			
		}return false;
	}
	
	//출력
	public ArrayList<MemberDto> list() {
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			String sql = "select * from member;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
			
		}return null;
	}
	
	//수정
	public boolean update(int mno, String mpw) {
		try {
			//String sql = "update member set mpw='"+mpw+"' where mno = "+mno+";";
			String sql = "update member set mpw=? where mno = ?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mpw);
			ps.setInt(2, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
			
		}return false;
	}
	
	
	//삭제
	public boolean delete(int mno) {
		try {
			String sql = "delete from member where mno="+mno+";";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
			return false;
		}
		
	}
	
	
}
