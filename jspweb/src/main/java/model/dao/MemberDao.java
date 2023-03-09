package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao () {};
	
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid,mpwd,memail,mimg) values(?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
		
	}
	
	
	public ArrayList<MemberDto> memberList() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean idcheck(String mid) {
		String sql = "select * from member where mid='"+mid+"';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	
	
	public boolean login(String mid, String mpwd) {
		String sql = "select * from member where mid='"+mid+"' and mpwd='"+mpwd+"';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public MemberDto getMember(String mid) {
		String sql = "select * from member where mid='"+mid+"';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), null, rs.getString(4), rs.getString(5));
				return dto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
}
