package 과제.과제9.인터페이스.nfc;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		nfc nfc =null;
		while (true) {
			System.out.println("1. 삼성페이 2. 출입시스템");
			int ch = scanner.nextInt();
			if(ch==1) {nfc = new 삼성페이();}
			else if(ch==2) {nfc = new 출입시스템();}
				
			System.out.println("1. 켜기 2. 끄기");
			int ch2 = scanner.nextInt();
			if(ch2==1) {
				nfc.nfcOn();
			}if(ch2==2) {
				nfc.nfcOff();
			}
			
		}
		
		
	}
}
