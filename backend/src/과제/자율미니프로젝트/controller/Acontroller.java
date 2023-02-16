package 과제.자율미니프로젝트.controller;

import 과제.자율미니프로젝트.model.Member;
import 과제.자율미니프로젝트.model.Professer;


public class Acontroller extends Mcontroller {
	
	
	// admin 계정 미리 한개 생성 1.로그인 2. 아이디찾기 3. 비밀번호찾기 / (hide) 4. 관리자로그인 /
	// ch => 4 일때 관리자로그인 
	

	
	// 1. 학생 / 교수 등록 ( ch 로 학생, 교수 선택 ) 
	public boolean add_member( int ch , String id , String comfirmpw, String pw, String name, String phone ) {
		
		if( ch == 1 ) { // 학생 등록
			
			int mno = 0;
			if(Mcontroller.MemberDB.size()==0) {
				mno=100;
			}else {
				mno = Mcontroller.MemberDB.get(Mcontroller.MemberDB.size()-1).mno+1;
			}
			
			
			if( pw.equals(comfirmpw)) { // 패스워드 , 패스워드 확인 
				Member student = new Member(mno, id, pw, name, phone); //학생 객체 생성
				MemberDB.add(student); // DB 저장
				return true;
			}
			
		}
		else if( ch == 2 ) { // 교수 등록
			
			int mno = 0;
			if(Mcontroller.MemberDB.size()==0) {
				mno=200;
			}else {
				mno = Mcontroller.MemberDB.get(Mcontroller.MemberDB.size()-1).mno+1;
			}
			
			if( pw.equals(comfirmpw)) {
				Member professer = new Member(mno, id, pw, name, phone); // 교수 객체 생성
				MemberDB.add(professer);
				return true;
			}
		}
		return false;
	}
	
	// 2. 강의등록
	public boolean subject_reg( String subject ) {
		
		int suno = 0;
		if(Pcontroller.subjctDB.size()==0) {
			suno=0;
		}else {
			suno = Pcontroller.subjctDB.get(Pcontroller.subjctDB.size()-1).suno+1;
		}
		// 유효성검사
		for( int i=0; i<Pcontroller.subjctDB.size(); i++ ) {
			if( !Pcontroller.subjctDB.get(i).subject.equals(subject) ) {
				// 만약에 subjectDB의 i 번째 제목이 입력받은 제목같지 않다면
				Professer subject1 = new Professer(suno, subject);
				Pcontroller.subjctDB.add(subject1);
				return true; 
			}
		}
		return false; 
	}
	
	
	
	
}
