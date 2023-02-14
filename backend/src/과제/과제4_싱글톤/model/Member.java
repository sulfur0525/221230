package 과제.과제4_싱글톤.model;

import java.util.ArrayList;

// M : 데이터를 저장할때 사용되는 데이터 모델링
	// - 회원[객체] 여러명 만들어서 하나의 리스트에 저장 -> 인스턴스 
	// - 필드 : private 외부 직접 접근 방지 -> getter, setter
public class Member {
	
	// 인스턴스 멤버 : 객체있어야 사용
	// 정적멤버 : static 객체없이 사용
	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	// 한명의 회원[객체]가 여러개의 board객체를 가질 수 있다. 
	private ArrayList<Board> boardList;
	
	// 2. 생성자
	public Member() {}

	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardList) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", boardList=" + boardList
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	
	
	
	// 3. 메소드 

}
