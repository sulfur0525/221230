package 과제.과제4.view;
// 입출력 : print, scanner


import java.util.Scanner;
import 과제.과제4.controller.Mcontroller;


public class Front {
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	
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

}
