package 과제.과제4_싱글톤.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Bcontroller;
import 과제.과제4_싱글톤.controller.Mcontroller;
import 과제.과제4_싱글톤.model.Board;

public class Front {
	
	//*싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {return front;}
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지
	public void index() {
		while (true) {
			System.out.println("---------이젠 커뮤니티---------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch = scanner.nextInt();
			if(ch==1) {singup_page();}
			else if(ch==2) {login_page();}
			else if(ch==3) {findid_page();}
			else if(ch==4) {findpw_page();}
			else {}
		}
	}
	
	// 2. 회원가입 페이지
	public void singup_page() {
		// 1. 입력부
		System.out.println("아이디 :");  String id = scanner.next();
		System.out.println("비밀번호 :");	 String pw = scanner.next();
		System.out.println("비밀번호확인 :"); String confirmpw = scanner.next();
		System.out.println("이름 :"); String name = scanner.next();
		System.out.println("전화번호 :"); String phone = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기
		int result = 
		Mcontroller.getInstance().singup(id, pw, confirmpw, name, phone);
		// 3. 결과제어
		if(result==1) {System.out.println("[알림]회원가입실패. 패스워드가 서로 다릅니다.");}
		else if(result==2) {System.out.println("[알림]회원가입성공");}
	}
	
	// 3. 로그인 페이지
	public void login_page() {
		//1. 입력부
		System.out.println("아이디 :");  String id = scanner.next();
		System.out.println("비밀번호 :");	 String pw = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기
		int result = 
		Mcontroller.getInstance().login(id, pw);
		// 3. 결과제어
		if(result==-1) {System.out.println("[알림]로그인실패. 패스워드가 다릅니다.");}
		else if(result==-2) {System.out.println("[알림]로그인실패. 아이디가 다릅니다.");}
		else {System.out.println("[알림]로그인성공.안녕하세요"); board_page();}
		// 로그인 성공시 게시물을 볼 수 있도록 board_page() 함수로 이동[호출]
	}
	
	// 4. 아이디 찾기 페이지
	public void findid_page() {
		//1. 입력부
		System.out.println("이름 :"); String name = scanner.next();
		System.out.println("전화번호 :"); String phone = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기
		String result = 
		Mcontroller.getInstance().findId(name, phone);
		// 3. 결과제어
		if(result==null) {System.out.println("[알림]아이디 찾기 실패");}
		else {System.out.println("[알림]회원님의 아이디는 "+result+"입니다.");}
	}
	
	// 5. 비밀번호 찾기 페이지
	public void findpw_page() {
		//1. 입력부
		System.out.println("아이디 :");  String id = scanner.next();
		System.out.println("전화번호 :"); String phone = scanner.next();
		// 2. 컨트롤에게 전달 후 결과 받기
		String result = 
		Mcontroller.getInstance().findPassword(id, phone);
		// 3. 결과제어
		if(result==null) {System.out.println("[알림]비밀번호 찾기 실패");}
		else {System.out.println("[알림]회원님의 비밀번호는 "+result+"입니다.");}	
	}
	
	// 6. 로그인성공시 게시물 출력 페이지
	public void board_page() {
		while (true) {
			System.out.println("------------커뮤니티-------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			
			
			int i = 0 ;
			for(Board b : Bcontroller.getInstance().getList()) {
				System.out.println(i+"\t"+b.getViews()+"\t"+b.getMember().getId()+"\t"+b.getTitle());
				i++;
			}
			
			System.out.println("1.글쓰기 2.글보기 3.로그아웃");
			int ch = scanner.nextInt();
			if(ch==1) {	write_page();}
			else if(ch==2) {view_page();}
			else if(ch==3) {Mcontroller.getInstance().logOut(); break;}
		}
	}
	
	// 7. 게시물 쓰기 페이지
	public void write_page() {
		System.out.println("-----------글쓰기----------");
		System.out.println("제목 : " ); String title = scanner.next();
		System.out.println("내용 : " ); String contents = scanner.next();
		boolean result = Bcontroller.getInstance().write(title, contents);
		if(result) {System.out.println("[알림] 글 작성 성공");}
		else {System.out.println("[알림] 글 작성 실패");}
	}
	
	// 8. 게시물 상세 페이지
	public void view_page() {
		System.out.println("이동할 게시물 번호 : "); int bno = scanner.nextInt();
		Board result = Bcontroller.getInstance().getBoard(bno);
		System.out.println("------------글상세-----------");
		System.out.println("제목 : "+result.getTitle());
		System.out.println("작성자 : "+result.getMember().getName() + "\t조회수 : "+result.getViews());
		System.out.println("내용 : "+result.getContent());
		
		System.out.println("1.글삭제 2.글수정 3.뒤로가기 ");
		int ch = scanner.nextInt();
		if(ch==1) {delete_page(bno);  }
		else if(ch==2) {update_page(bno);}
		else if(ch==3) {return;}
	}
	
	// 9. 게시물 삭제 페이지
	public void delete_page(int bno) {
		// 1. 유효성검사[현재 보고 있는 글의 작성자와 현재 로그인된 회원이 같으면]
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLogSession())) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("[알림]삭제가 되었습니다.");
			return;
		}else {System.out.println("[알림] 삭제 권한이 없습니다.");}
	}
	
	// 10. 게시물 수정 페이지
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLogSession())) {
			System.out.println("-----------글수정----------");
			System.out.println("새로운 제목 : " ); String title = scanner.next();
			System.out.println("새로운 내용 : " ); String contents = scanner.next();
			Bcontroller.getInstance().update(bno, title, contents);
			System.out.println("[알림] 글 수정 성공");
			return;
		}
		else {System.out.println("[알림] 글 수정 권한이 없습니다.");}
		
	}
	
	
}
