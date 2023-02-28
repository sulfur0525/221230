package Day20.gallery.view;

import java.util.Scanner;

import Day20.gallery.controller.Mcontroller;

public class IndexView {
	private static IndexView indexView = new IndexView();
	private IndexView() {};
	public static IndexView getInstence() {return indexView;}
	
	private Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while (true) {
			System.out.println("1.로그인 2.회원가입");
			try {
				int ch = scanner.nextInt();
				if(ch==1) {}
				else if(ch==2) {signup();}
			} catch (Exception e) {
				System.err.println("[알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
			
		}
	}
	
	
	//  회원가입 페이지
	public void signup() throws Exception{
		System.out.println("============회원가입============");
		System.out.println("아이디 : "); String mid = scanner.next();
		System.out.println("비밀번호 : "); String mpw = scanner.next();
		System.out.println("이름 : "); String mname = scanner.next();
		System.out.println("전화번호 : "); String mphone = scanner.next();
		
		int result = Mcontroller.getInstence().signup(mid, mpw, mname, mphone);
		if(result==1) {
			System.out.println("[알림] 회원가입이 되었습니다.");
		}else if(result ==2 ) {System.out.println("[알림] 존재하는 아이디 입니다.");
		}else {System.out.println("[알림] 시스템 오류 : 관리자에게 문의");}
	}
	
	
	//로그인 페이지
	public void login() throws Exception{
		System.out.println("============로그인============");
		System.out.println("아이디 : "); String mid = scanner.next();
		System.out.println("비밀번호 : "); String mpw = scanner.next();
		boolean result = Mcontroller.getInstence().login(mid, mpw);
		if(result) {
			System.out.println("[알림] 로그인 성공");
		}else {
			System.out.println("[알림] 로그인 실패");
		}
		
	}
	
}
