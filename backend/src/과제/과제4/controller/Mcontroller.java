package 과제.과제4.controller;
//데이터 모델링

import java.util.ArrayList;
import 과제.과제4.model.Member;

public class Mcontroller {
	
	ArrayList<Member> memberDb = new ArrayList<>();
	
	//1. 회원가입 로직
	public int signup(String id, String pwd, String confirmpwd,String name, String phone) {
		//1. 유효성 검사
		if(!pwd.equals(confirmpwd)) {return 1;}//회원가입 실패 1
		//2. 객체 만들어서
		Member member = new Member(id, pwd, name, phone);
		//3. db처리
		memberDb.add(member);
		return 0; // 회원가입 성공 0
	}
	//2. 로그인 로직
	public int login (String id, String pwd) {
		for(int i = 0 ; i<memberDb.size() ; i++) {
			if(id.equals(memberDb.get(i).id)) {
				if(pwd.equals(memberDb.get(i).pwd)) {
					return 1;//로그인 성공
				}else {return 2;}//비밀번호 틀림
			}else {return 3;}//아이디 틀림
		}
		return 3;//로그인 실패
	}

	//3. 아이디 찾기 로직
	public String findId(String name,String phone) {
		for(int i = 0 ; i<memberDb.size() ;i++ ) {
			if(name.equals(memberDb.get(i).name)) {
				if(phone.equals(memberDb.get(i).phone)) {
					return memberDb.get(i).id;
				}else {return"전화번호가 틀립니다.";}
			}
		}
		return "이름이 존재하지 않습니다.";
	}
	//4. 비밀번호 찾기 로직
	public String findPassword(String id,String phone) {
		for(int i = 0 ; i<memberDb.size() ;i++ ) {
			if(id.equals(memberDb.get(i).id)) {
				if(phone.equals(memberDb.get(i).phone)) {
					return memberDb.get(i).pwd;
				}else {return"전화번호가 틀립니다.";}
			}
		}
		return "아이디가 존재하지 않습니다.";
	}
	
	
	
	
	
	
	
}
