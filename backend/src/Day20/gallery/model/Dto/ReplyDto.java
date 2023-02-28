package Day20.gallery.model.Dto;

public class ReplyDto {
	private int rno;
	private String  rcontent;
	private String rdate;
	private int rindex;
	private String mid;
	private int bno;
	
	public ReplyDto() {
		// TODO Auto-generated constructor stub
	}

	public ReplyDto(int rno, String rcontent, String rdate, int rindex, String mno_fk, int bno_fk) {
		super();
		this.rno = rno;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.mid = mno_fk;
		this.bno = bno_fk;
	}

	@Override
	public String toString() {
		return "ReplyDto [rno=" + rno + ", rcontent=" + rcontent + ", rdate=" + rdate + ", rindex=" + rindex
				+ ", mno_fk=" + mid + ", bno_fk=" + bno + "]";
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public String getMno_fk() {
		return mid;
	}

	public void setMno_fk(String mno_fk) {
		this.mid = mno_fk;
	}

	public int getBno_fk() {
		return bno;
	}

	public void setBno_fk(int bno_fk) {
		this.bno = bno_fk;
	}
	
	
	
	
}
