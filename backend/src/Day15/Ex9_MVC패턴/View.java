package Day15.Ex9_MVC패턴;

import java.util.Scanner;

public class View {
	Scanner scanner = new Scanner(System.in);
	private static View view = new View();
	private View() {}
	public static View getInstance() {
		return view;
	}
	
	public void index() {
		while (true) {
			System.out.println("1.회원등록 2.회원출력 3.회원수정 4.회원삭제");
			int ch = scanner.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {list();}
			else if(ch==3) {update();}
			else if(ch==4) {delete();}
		}
	}
	
	public void signup() {
		System.out.println("아이디 : " ); String mid = scanner.next();
		System.out.println("비밀번호 : " ); String mpw = scanner.next();
		boolean result = Controller.getInstance().singup(mid, mpw);
		if(result) {
			System.out.println("[ 회원등록 성공 ]");
		}else {
			System.out.println("[ 회원등록 실패 ]");
		}
	}
	
	public void list() {
		String memberList = Controller.getInstance().list();
		System.out.println(memberList);
	}
	
	public void update() {
		System.out.println("회원번호 : "); int mno = scanner.nextInt();
		System.out.println("새로운 비밀번호 : "); String mpw = scanner.next();
		boolean result = Controller.getInstance().update(mno, mpw);
		if(result) {
			System.out.println("[ 비밀번호 변경 성공 ]");
		}else {
			System.out.println("[ 비밀번호 변경 실패 ]");
		}
	}
	
	public void delete() {
		System.out.println("삭제할 회원번호 : "); int mno = scanner.nextInt();
		boolean result = Controller.getInstance().delete(mno);
		if(result) {
			System.out.println("[ 삭제 성공 ]");
		}else {
			System.out.println("[ 삭제 실패 ]");
		}
	}
}
