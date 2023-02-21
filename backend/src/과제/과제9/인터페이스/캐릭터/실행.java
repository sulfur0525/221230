package 과제.과제9.인터페이스.캐릭터;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		캐릭터 캐릭터 = null;
		
		while (true) {
			System.out.println("플래이할 캐릭터를 골라주세요");
			System.out.println("1.검사 | 2.궁수 | 3.마법사");
			int ch = scanner.nextInt();
			if(ch==1) {캐릭터 = new 검사();}
			else if(ch==2) {캐릭터 = new 궁수();}
			else if(ch==3) {캐릭터 = new 마법사();}
		
			System.out.println("1.공격하기 | 2. 방어하기");
			int ch2 = scanner.nextInt();
			if(ch2==1) {캐릭터.attack();}
			else if(ch2==2) {캐릭터.defence();}
		}
	}
}
