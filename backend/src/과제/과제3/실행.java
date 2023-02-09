package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Book> bookList = new ArrayList<>(); 
		ArrayList<Member> memberList = new ArrayList<>();
		Member login = new Member();
		int 로그인성공 = -1;
		
		
		
		로그인 : while (true) {
			System.out.println("메뉴 > 1.로그인 2.회원가입");
			int ch2 = scanner.nextInt();
			
			if(ch2==1) {
				
				System.out.println("아이디 : ");
				login.아이디= scanner.next();
				System.out.println("비밀번호 : ");
				login.비밀번호= scanner.next();
				
				for(int i = 0 ; i<memberList.size() ; i++) {
					if(login.아이디.equals(memberList.get(i).아이디)) {
						if(login.비밀번호.equals(memberList.get(i).비밀번호)) {
							System.out.println("로그인에 성공하였습니다.");
							로그인성공=i;
							break 로그인;
						}else {
							System.out.println("비밀번호가 틀렸습니다.");
						}
					}else {
						System.out.println("존재하지 않는 아이디 입니다.");
					}
				}
				
			}else if(ch2==2) {
				Member member = new Member();
				System.out.println("아이디 : ");
				member.아이디 = scanner.next();
				System.out.println("비밀번호 : ");
				member.비밀번호 = scanner.next();
				System.out.println("이름 : ");
				member.이름 = scanner.next();
				System.out.println("전화번호 : ");
				member.전화번호 = scanner.next();
				
				memberList.add(member);
				
			}else {
				System.out.println("잘못된 선택입니다. 다시 입력하십시오.");
			}
		}

		while (true) {
			System.out.println("------------이젠 도서관------------");
			System.out.println("번호\t대여여부\t도서장르\t도서명\t대여회원");
			for(int i = 0 ; i<bookList.size() ; i++) {
				System.out.println(i+"\t"+
						bookList.get(i).도서대여여부+"\t"+
						bookList.get(i).도서장르+"\t"+
						bookList.get(i).도서명+"\t"+
						bookList.get(i).회원아이디);
			}
			
			System.out.println("---------마이페이지----------------");
			System.out.println("번호\t대여목록");
			for(int i = 0 ; i<memberList.get(로그인성공).대여목록.size() ; i++) {
				System.out.println(i+"\t"+memberList.get(로그인성공).대여목록.get(i));
			}
			
			
			System.out.println("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자]");
			int ch = scanner.nextInt();
			if(ch==1) {//도서대여
				System.out.println("대여할 도서번호 선택 : ");
				int num = scanner.nextInt();
				if(bookList.get(num).도서대여여부=="가능") {
					System.out.println(bookList.get(num).도서명 + " 대여완료");
					bookList.get(num).도서대여여부 ="불가능";
					bookList.get(num).회원아이디 = login.아이디;
					memberList.get(로그인성공).대여목록.add(bookList.get(num).도서명);
				}else {
					System.out.println(bookList.get(num).도서명 + " 대여불가");
				}
			}else if(ch==2) {//도서반납
				System.out.println("반납할 도서번호 선택 : ");
				int num = scanner.nextInt();
				if(bookList.get(num).도서대여여부=="가능") {
					System.out.println(bookList.get(num).도서명 + " 반납불가");
				}else {
					System.out.println(bookList.get(num).도서명 + " 반납완료");
					bookList.get(num).도서대여여부="가능";
					bookList.get(num).회원아이디 = "";
					memberList.get(로그인성공).대여목록.remove(memberList.get(로그인성공).대여목록.indexOf(bookList.get(num).도서명));
				}
			}else if(ch==3) {//도서등록
				Book book = new Book();
				System.out.println("등록할 도서명 : ");
				book.도서명 = scanner.next();
				System.out.println("등록할 도서장르 : ");
				book.도서장르 = scanner.next();
				book.도서대여여부 = "가능";
				book.회원아이디 = "";
				bookList.add(book);
				
			}else {
				System.out.println("잘못된 선택입니다. 다시 입력하십시오.");
			}
			
		}
		
		
		
		
	}
}
