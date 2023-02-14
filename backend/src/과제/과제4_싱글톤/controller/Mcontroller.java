package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Member;

public class Mcontroller {
	
	// * 싱글톤 : 다른 곳에서 해당 객체를 공유 메모리[멤버 = 필드, 메소드]
		// 1. 본인 클래스로 본인 객체 만들기
	private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자를 사용할 수 없도록 생성자에 private
	private Mcontroller() {}
		//3. 객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다. [유효성검사 위해]
	public static Mcontroller getInstance( ) {
		return mc;
	}
	
	// DB 대신 ArrayList
	private ArrayList<Member> memberDB = new ArrayList<>();
	//로그인 한 회원의 객체를 저장[*동시접속 시 문제점 발생]
		// 사용목적 : 페이지가 바뀌더라도 정보 저장[* 메소드가 종료 되더라도 정보는 저장]
	private Member logSession = null;

	public Member getLogSession() {
		return logSession;
	}
	
	// 1. 회원가입처리
	public int singup(String id, String pw, String confirmpw,
							String name, String phone) {
		
		// 1. 유효성 검사
		if(!pw.equals(confirmpw)) {return 1;}
		// 2. DB에 저장
			// 1. 객체화 [입력받은 데이터 4개와, 회원마다 글을 저장할 리스드 메모리 초기화]
		Member m = new Member(id, pw, name, phone, new ArrayList<>());
				// id, pw, name, phone : 스택 영역에 저장된 힙주소 전달
				// new ArrayList<>() :  힙영역에 생성된 힙주소 전달
			// 2. 리스트에 전달
		memberDB.add(m);
		return 0;
	}
	
	// 2. 로그인 처리
	public int login (String id, String pw) {
		for(int i = 0 ; i<memberDB.size() ; i++) {
			if(memberDB.get(i).getId().equals(id)) {//i번째 인덱스의 아이디와 입력받은 아이디와 같으면
				if(memberDB.get(i).getPw().equals(pw)) {
					// i 번째 인덱스의 비밀번호와 입력받은 비밀번호와 같으면 로그인 성공[ 로그인 성공했을때 흔적 남기기]
					logSession = memberDB.get(i); //로그인 성공한 회원 객체를 필드에 저장 
					return i;
				}
			}
		}
		//로직 작성할 예정
		return -2;
	}
	
	// 3. 아이디 찾기 처리
	public String findId(String name,String phone) {
		for(Member m : memberDB) {// memberDB 여러개의 member객체가 들어있고 하나씩 객체를 꺼내기 반복
			if(m.getName().equals(name)&&m.getPhone().equals(phone)) {
				return m.getId();
			}
		}
		return null;
	}
	
	// 4. 비밀번호 찾기 처리
	public String findPassword(String id,String phone) {
		for(Member m : memberDB) {
			if(m.getId().equals(id)&&m.getPhone().equals(phone)) {
				return m.getPw();
			}
		}
		return null;
	}
	
	// 5. 로그아웃
	public boolean logOut() {
		logSession = null;//필드에 저장된 로그인 성공한 회원 객체 지우기[ null 대입하면 GC가 메모리 자동제거]
		return true;
	}
	
}
