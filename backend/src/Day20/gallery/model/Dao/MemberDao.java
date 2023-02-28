package Day20.gallery.model.Dao;

import Day20.gallery.model.Dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao dao = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstence() {return dao;}
	
	public boolean idCheck( String mid) {
		String sql = "select * from member where mid = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
			else {return false;}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
	
	
	public int signup(MemberDto dto) {
		String sql = "insert into member(mid, mpw, mname, mphone) values( ?,?,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 3;	
	}
	
	public int login(String mid,String mpw) {
		String sql = "select * from member where mid = ? and mpw=?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
			else {return 0;}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
