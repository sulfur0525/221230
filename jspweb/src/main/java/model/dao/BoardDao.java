package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;
import practice.day03.board;

public class BoardDao extends Dao {
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return dao; }
	
	public boolean bwrite(BoardDto dto) {
		String sql = "insert into board(btitle,bcontent,bfile,mno,cno) values(?,?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public int gettotalsize(String key,String keyword,int cno) {
		String sql ="";
		if(key.equals("")&&keyword.equals("")) {
			sql = "select count(*) from board b natural join member m where b.cno="+cno+";";
		}else {
			sql = "select count(*) from board b natural join member m where "+key+" like '%"+keyword+"%' and b.cno = "+cno+" order by b.bdate desc;";
		}
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}return 0;
	}
	
	public ArrayList<BoardDto> getBoardList(int startrow, int listsize ,String key,String keyword, int cno) {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "";
		if(key.equals("")&&keyword.equals("")) {
			sql = "select b.*, m.mid from board b natural join member m where b.cno="+cno+" limit ? , ?;";
		}else {
			sql = "select b.*, m.mid from board b natural join member m where "+key+" like '%"+keyword+"%' and b.cno = "+cno+" order by b.bdate desc limit ? , ?;";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDto boardDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getInt(6), 
									rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),rs.getString(11));
				list.add(boardDto);
			}return list;
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public BoardDto getBoard(int bno) {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select b.*, m.mid, mimg from board b natural join member m where b.bno="+bno+";";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				BoardDto boardDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), 
						rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),rs.getString(11), rs.getString(12));
				return boardDto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean bIncrease(int type , int bno) {
		String sql = "";
		if(type==1) {sql = "update board set bview = bview+1 where bno = "+bno+";";}
		if(type==2) {sql = "update board set bup = bup+1 where bno = "+bno+";";}
		if(type==3) {sql = "update board set bdown = bdown+1 where bno = "+bno+";";}
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
		
	}
	
	public boolean bdelete(int bno) {
		String sql = "delete from board where bno = "+bno+";";
		try {
			ps = con.prepareStatement(sql);
			int cnt = ps.executeUpdate();
			if(cnt==1) {
			return true;}
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	
	public boolean bupdate(BoardDto dto) {
		String sql = "update board set btitle=? ,bcontent=? , bfile=? , cno=?  where bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getCno());
			ps.setInt(5, dto.getBno());
			int cnt = ps.executeUpdate();
			if(cnt == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
}
