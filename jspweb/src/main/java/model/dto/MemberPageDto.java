package model.dto;

import java.util.ArrayList;

public class MemberPageDto {
	private int page;//
	private int listsize;
	private int startrow;
	private int totalsize;
	private int totalpage;
	private int btnsize;
	private int startbtn;
	private int endbtn;
	
	ArrayList<MemberDto> memberList;
	
	public MemberPageDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberPageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsize, int startbtn,
			int endbtn, ArrayList<MemberDto> memberList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsize = btnsize;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "MemberPageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnsize=" + btnsize + ", startbtn=" + startbtn
				+ ", endbtn=" + endbtn + ", memberList=" + memberList + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBtnsize() {
		return btnsize;
	}

	public void setBtnsize(int btnsize) {
		this.btnsize = btnsize;
	}

	public int getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}

	public int getEndbtn() {
		return endbtn;
	}

	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}

	public ArrayList<MemberDto> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<MemberDto> memberList) {
		this.memberList = memberList;
	}
	
	
}
