package model.dto;

import java.util.ArrayList;

public class PageDto {
	private int page;//
	private int listsize;
	private int startrow;
	private int totalsize;
	private int totalpage;
	private int btnsize;
	private int startbtn;
	private int endbtn;
	
	ArrayList<BoardDto> boardList ;
	
	public PageDto() {
		// TODO Auto-generated constructor stub
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

	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsize, int startbtn,
			int endbtn, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsize = btnsize;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardList = boardList;
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, ArrayList<BoardDto> boardDto) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.boardList = boardDto;
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

	public ArrayList<BoardDto> getBoardDto() {
		return boardList;
	}

	public void setBoardDto(ArrayList<BoardDto> boardDto) {
		this.boardList = boardDto;
	}

	@Override
	public String toString() {
		return "PageDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnsize=" + btnsize + ", startbtn=" + startbtn
				+ ", endbtn=" + endbtn + ", boardList=" + boardList + "]";
	}
	
	

}
