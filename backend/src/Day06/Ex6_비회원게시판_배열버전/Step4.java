package Day06.Ex6_비회원게시판_배열버전;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Step4 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		
		
		while (true) {
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			byte[] inbytes = new byte[1000];
			int bytecount = fin.read(inbytes);
			String boardlist =  new String(inbytes,0,bytecount);
			
			String[] line = boardlist.split("\n");
			
			
			System.out.println("-----------게시판-----------");
			System.out.printf("%4s %6s %6s %5s","번호","제목","작성자","조회수" + "\n");
			for(int i = 0 ; i<line.length ; i++) {
				String[] text = line[i].split(",");
				
				System.out.printf("%4s %6s %6s %5s",i+1,text[0],text[2],"조회수" + "\n");
			}
			
			
			
			
			
			
			System.out.println("메뉴>");
			System.out.println("게시물 번호 : 게시물 상세 보기");
			System.out.println("-1 : 쓰기");
			System.out.println("-2 : 나가기");
			int 메뉴선택 = scanner.nextInt();
			
			
			if(메뉴선택>0) {
				System.out.println("해당번호 게시물 상세보기");
			}
			if(메뉴선택==-1) {
				System.out.println("-----------게시물 작성-------------");
				System.out.println("제목 : ");String 제목 = scanner.next();
				System.out.println("내용 : ");String 내용 = scanner.next();				
				System.out.println("작성자 : ");String 작성자 = scanner.next();				
				System.out.println("비밀번호 : ");String 비밀번호 = scanner.next();
				
				String outstr = 제목+","+내용+","+작성자+","+비밀번호+"\n";
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true);
				fout.write(outstr.getBytes());
				
				
			}else if(메뉴선택==-2) {
				System.out.println("종료");
				break;
			}
		}
		
		
		
	}
}
