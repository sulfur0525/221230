package 과제.과제4_싱글톤.model;

/*
	
	model 관계
		1. 한명의 회원이 글 작성한다.		[object]
		2. 회원은 여러개의 글을 작성할 수 있다. [ArrayList]
		
 */

public class Board {
	// 1. 필드
	private String title;
	private String content;
	private int views;
	// 하나의 게시물[객체]가 하나의 member 객체를 가질 수 있다. 
	private Member member;
	
	// 2. 생성자
	public Board() {}

	public Board(String title, String content, int views, Member member) {
		super();
		this.title = title;
		this.content = content;
		this.views = views;
		this.member = member;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", views=" + views + ", member=" + member + "]";
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
}
