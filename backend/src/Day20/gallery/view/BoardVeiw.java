package Day20.gallery.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.controller.Bcontroller;
import Day20.gallery.controller.Mcontroller;
import Day20.gallery.model.Dao.BoardDao;
import Day20.gallery.model.Dto.BoardDto;
import Day20.gallery.model.Dto.CategoryDto;

public class BoardVeiw {
	private static BoardVeiw boardVeiw = new BoardVeiw();
	private BoardVeiw() {};
	public static BoardVeiw getInstence() {return boardVeiw;}
	
	private Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while (true) {
			System.out.println("===========이젠 갤러리===========");
			boardPrintRecent();
			System.out.println("===========갤러리 목록===========");
			categoryPrint();
			
			System.out.println("-1:로그아웃 / 0: 갤러리 추가 / 이동할 갤러리 번호 선택 : ");
			int ch = scanner.nextInt();
			if(ch==0) {categoryAdd();}
			else if(ch>0){boardPrint(ch);}
			else if(ch==-1) {
				Mcontroller.getInstence().setLoginSession(0); 
				System.out.println("[알림]로그아웃");
				break;}
		}
	}
	
	public void categoryAdd() {
		System.out.println("===========갤러리 추가===========");
		scanner.nextLine();
		System.out.println("추가할 갤러리 이름 : "); String cname = scanner.nextLine();
		
		boolean result = Bcontroller.getInstence().categoryAdd(cname);
		if(result) {System.out.println("[등록성공] 갤러리가 추가되었습니다");}
		else {System.out.println("[등록실패] 관리자에세 문의");}
		
	}
	
	public void categoryPrint() {
		ArrayList<CategoryDto> clist = Bcontroller.getInstence().categoryPrint();
		
		int cnt=0;
		for(CategoryDto c : clist){
			System.out.println(c.getCno()+"-"+c.getCname()+"\t");
			cnt++;
			if(cnt/4==0)System.out.println();
		}
	}
	
	// 4. 게시물 쓰기 페이지 
		public void boardAdd( int cno ) {
			System.out.println(" =============== 게시물 쓰기 ============== ");
			System.out.print(" 제목 : " ); 	String btitle = scanner.next();
			System.out.print(" 내용 : " );	String bcontent = scanner.next();
			boolean result = Bcontroller.getInstence().boardAdd( btitle, bcontent , cno );
			if( result ) { System.out.println("[글등록성공]");}
			else { System.out.println("[글등록실패]");}
			
		}
		// 5. 최신 글 3개 출력 페이지
		public void boardPrintRecent(  ) {
			System.out.println(" =============== 최신글 ============== ");
			ArrayList< BoardDto > blist = Bcontroller.getInstence().boardPrintRecent();
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
								"번호" , "제목" , "작성자" , "조회수" ,  "갤러리", "작성일");
			for( BoardDto dto : blist  ) {
				System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
						dto.getBno() , dto.getBtitle() , dto.getMid() ,
						dto.getBview() , dto.getCname() , dto.getBdate() );
			}
		}
		// 6. 선택한 갤러리의 모든 게시물 페이지 
		public void boardPrint( int cno ) {
			System.out.println(" =============== 선택한 갤러리 ============== ");
			ArrayList<BoardDto> blist = Bcontroller.getInstence().boardPrint(cno);
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s \n" ,
							"번호" , "제목" , "작성자" , "조회수" ,  "작성일" );
			for( BoardDto dto : blist  ) {
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s \n" ,
					dto.getBno() , dto.getBtitle() , dto.getMid() ,
					dto.getBview()  , dto.getBdate() );
			} // for end 
			while( true ) {
				System.out.print("갤러리 메뉴 : 1.뒤로가기 2.게시물쓰기 3.게시물보기 : ");
				int ch = scanner.nextInt();
				if( ch == 1 ) { break; }
				else if( ch == 2 ) { boardAdd( cno ); }
				else if( ch == 3 ) {  
					// 미구현
				}
			}
		}
	
}
