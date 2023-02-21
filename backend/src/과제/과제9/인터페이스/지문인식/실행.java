package 과제.과제9.인터페이스.지문인식;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		지문인식 지문인식 = null;
		while (true) {
			System.out.println("잠금을 해제하려면 지문을 인식해 주세요.");
			String 지문 = scanner.next();
			지문인식 = new 잠금화면();
			지문인식.compare(지문);
			
			System.out.println("00을 구매하려면 지문을 인식해 주세요.");
			String 지문2 = scanner.next();
			지문인식 = new 결제화면();
			지문인식.compare(지문2);
		}
		
	}
}
