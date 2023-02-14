package 과제.과제5.model;

public class Memo {
	private int memoNo;
	private String title;
	private String content;
	private int pno; 	//제품
	private int mno;	//보낸사람
	
	//생성자
	public Memo() {}

	public Memo(int memoNo, String title, String content, int pno, int mno) {
		super();
		this.memoNo = memoNo;
		this.title = title;
		this.content = content;
		this.pno = pno;
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Memo [memoNo=" + memoNo + ", title=" + title + ", content=" + content + ", pno=" + pno + ", mno=" + mno
				+ "]";
	}

	public int getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	

	
	
}
