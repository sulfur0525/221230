package Day20.gallery.model.Dao;

import java.util.ArrayList;

import Day20.gallery.model.Dto.BoardDto;
import Day20.gallery.model.Dto.CategoryDto;

public class BoardDao extends Dao{
	private static BoardDao dao = new BoardDao();
	private BoardDao() {};
	public static BoardDao getInstence() {return dao;}
	
	public boolean categoryAdd(String cname) {
		String sql = "insert into category(cname) values(?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}	
		return false;
	}
	
	public ArrayList<CategoryDto> categoryPrint() {
		ArrayList<CategoryDto> clist = new ArrayList<>();
		String sql = "select * from category";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDto dto = new CategoryDto(rs.getInt(1), rs.getString(2));
				clist.add(dto);
			}
			return clist;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public boolean boardAdd(String btitle, String bcontent, int cno, int mno) {
		String sql = "insert into board(btitle, bcontent, mno_fk, cno_fk) values(?,?,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.setInt(4, cno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}	
		return false;
	}
	
	public ArrayList<BoardDto> boardPrintRecent() {
		ArrayList<BoardDto> blist = new ArrayList<>();
		String sql =" select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
				+ " from board b , member m , category c "
				+ " where b.mno_fk = m.mno and b.cno_fk = c.cno "
				+ " order by b.bdate desc limit 3 ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				blist.add(dto);
			}
			return blist;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public ArrayList<BoardDto> boardPrint(int cno) {
		ArrayList<BoardDto> blist = new ArrayList<>();
		String sql =" select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
				+ "	from board b , member m , category c "
				+ "	where b.mno_fk = m.mno and b.cno_fk = c.cno and b.cno_fk = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDto dto =  new BoardDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				blist.add(dto);
			}
			return blist;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
}
