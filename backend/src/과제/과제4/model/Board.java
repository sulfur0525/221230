package 과제.과제4.model;

public class Board {
	//1. 필드
	public String title;
	public String contents;
	public int views;
	public Member member;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String title, String contents) {
		super();
		this.title = title;
		this.contents = contents;
	}

	public Board(String title, String contents, int views) {
		super();
		this.title = title;
		this.contents = contents;
		this.views = views;
	}

	public Board(String title, String contents, int views, Member member) {
		super();
		this.title = title;
		this.contents = contents;
		this.views = views;
		this.member = member;
	}
	
	
	
	
}
