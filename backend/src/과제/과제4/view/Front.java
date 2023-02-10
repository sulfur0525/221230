package 과제.과제4.view;
// 입출력 : print, scanner


import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;
import 과제.과제4.model.Member;


public class Front {
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc = new Bcontroller();
	int num = -1;
	
	 //1. 메인 페이지
	public void index() {
		while (true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기");
			int ch = scanner.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {login();}
			else if(ch==3) {findId();}
			else if(ch==4) {findPassword();}
			else {System.out.println("잘못된 선택입니다. 다시 선택하여 주십시오.");}
		}
	}
	
	//2. 회원가입 페이지
	void signup() {
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pwd = scanner.next();
		System.out.println("비밀번호 확인: ");String confirmpwd = scanner.next();
		System.out.println("이름 : ");String name = scanner.next();
		System.out.println("전화번호 : ");String phone = scanner.next();
		
		int result = mc.signup(id, pwd, confirmpwd, name, phone);
		if(result == 1) {
			System.out.println("[회원가입 실패]");
		}else if(result == 0) {
			System.out.println("[회원가입 성공]");
		}
	}
	
	//3. 로그인 페이지
	void login() {
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pwd = scanner.next();
		int result = mc.login(id, pwd);
		if(result>=0) {
			System.out.println("[로그인 성공]");
			num = result;
			loginSuccess();
		}else if(result == -1) {
			System.out.println("[비밀번호 틀림]");
		}else if(result == -2) {
			System.out.println("[아이디 틀림]");
		}
	}
	
	//4. 아이디 찾기 페이지
	void findId() {
		System.out.println("이름 : ");String name = scanner.next();
		System.out.println("전화번호 : ");String phone = scanner.next();
		String result = mc.findId(name, phone);
		System.out.println("아이디 : " + result);
	}
	//5. 비밀번호 찾기 페이지
	void findPassword() {
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("전화번호 : ");String phone = scanner.next();
		String result = mc.findPassword(id, phone);
		System.out.println("비밀번호 : " + result);
	}
	
	//6. 로그인 성공메뉴
	void loginSuccess() {
		while (true) {
			System.out.println("------------커뮤니티-------------");
			System.out.println("번호\t조회수\t작성자\t내용");
			String result = bc.boardPrint();
			System.out.println(result); 
			System.out.println("메뉴 > 1.글쓰기 2.글보기 3.로그아웃");
			int ch = scanner.nextInt();
			if(ch==1) {	post();}
			else if(ch==2) {postPrint();}
			else if(ch==3) {logout();}
			else {System.out.println("잘못된 선택입니다. 다시 선택하여 주십시오.");}
		}
	}
	
	//7. 글쓰기
	void post() {
		System.out.println("-----------글쓰기----------");
		System.out.println("제목 : " ); String title = scanner.next();
		System.out.println("내용 : " ); String contents = scanner.next();
		Member loginInfo = mc.loginInfo(num);
		System.out.println(num);int result = bc.posting(title,contents,loginInfo);
		
		if(result == 0) {
			System.out.println("글쓰기 성공");
		}
	}
	int bnum = -1;
	//8. 글보기
	void postPrint() {
		System.out.println("보고싶은 글 번호 : "); bnum = scanner.nextInt();
		String result = bc.postPrint(bnum);
		System.out.println("-----------글 상세----------");
		System.out.println(result);
		System.out.println("메뉴> 1.글삭제 2.글수정 3.뒤로가기 ");
		int ch = scanner.nextInt();
		if(ch==1) {	delete();}
		else if(ch==2) {editch();}
		else if(ch==3) {back();}
		else {System.out.println("잘못된 선택입니다.");}
	}
	//9. 로그아웃
	void logout() {
		System.out.println("로그아웃 하였습니다.");
		index();
	}
	
	//10. 글삭제
	void delete() {
		Member loginInfo = mc.loginInfo(num);
		int result  = bc.delete(bnum,loginInfo);
		if(result == 1) {System.out.println("[삭제성공]");}
		else {System.out.println("[삭제실패]");}
	}
	//11. 글수정 가능?
	void editch() {
		Member loginInfo = mc.loginInfo(num);
		int result  = bc.editch(bnum,loginInfo);
		if(result == 1) {edit();}
		else {System.out.println("[본인의 글이 아닙니다.]");}
	}
	//11-2
	void edit() {
		System.out.println("-------- 글 수정 -------------");
		System.out.println("새로운 내용 : "); String text = scanner.next();
		int result = bc.edit(bnum, text);
		System.out.println(result);
		if(result == 1) {System.out.println("[수정성공]");}
		
	}
	
	//12. 뒤로가기
	void back() {
		System.out.println("뒤로가기");
		loginSuccess();
	}
	
	
	

}
