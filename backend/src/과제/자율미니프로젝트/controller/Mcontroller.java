package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Member;


public class Mcontroller {
	public static ArrayList<Member> MemberDB = new ArrayList<>();
	public int logSession = -1;
	
	public int mno(String id) {
		int mno = -1;
		for(Member m : Mcontroller.MemberDB) {
			if(m.id.equals(id)) {
				mno = m.mno;
			}
		}
		return mno;
	}
	
	
	// 로그인
	public boolean login(String id, String pw) {
		for(Member m : MemberDB) {
			if(m.id.equals(id)) {
				if(m.pw.equals(pw)) {
					logSession = m.mno;
					return true;
				}
			}
		}
		return false;
	}
	
	// 아이디 찾기
	
	
}
