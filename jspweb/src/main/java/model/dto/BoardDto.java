package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {

	private int bno ; 		
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private int bview;
	private int bup;
	private int bdown;
	private int mno;
	private int cno;
	//  추가 필드 --> 작성자 id 
	private String mid;
	private String mimg;
	private int rcount;
	// 1. 생성자 [ 빈생성자 ] : 사용할 용도가 적음 
	public BoardDto() {}
	// 2. 생성자 [ 풀생성자 ] 
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
	}
	// 3. 등록용 생성자 
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}
	// 4. 출력용 생성자 
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
	}
	
	
	
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid, String mimg, int rcount) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		
		if(now.split(" ")[0].equals(bdate.split(" ")[0])) {
			this.bdate = bdate.split(" ")[1];
		}else {
			this.bdate = bdate.split(" ")[0];
		}
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
		this.mimg = mimg;
		this.rcount = rcount;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno = cno;
	}
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String now = sdf.format(date);
			
			if(now.split(" ")[0].equals(bdate.split(" ")[0])) {
				this.bdate = bdate.split(" ")[1];
			}else {
				this.bdate = bdate.split(" ")[0];
			}
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
		this.mimg = mimg;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getBup() {
		return bup;
	}
	public void setBup(int bup) {
		this.bup = bup;
	}
	public int getBdown() {
		return bdown;
	}
	public void setBdown(int bdown) {
		this.bdown = bdown;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", bup=" + bup + ", bdown=" + bdown + ", mno=" + mno
				+ ", cno=" + cno + ", mid=" + mid + ", mimg=" + mimg + "]";
	}
	
	
	
	
	
	
}





