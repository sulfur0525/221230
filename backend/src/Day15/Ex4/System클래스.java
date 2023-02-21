package Day15.Ex4;

import java.io.IOException;

public class System클래스 {
	
	public static void main(String[] args) {
		
		System.err.println("에러");
		System.out.println("출력");
		
		int value1 = 100;
		//int value2 = "100";
		
		int value3 = Integer.parseInt("100");
		
		try {
			int value4 = Integer.parseInt("1oo");
		} catch (NumberFormatException e) {
			System.err.println("[에러내용]");
			System.err.println(e.getMessage());
		}
		
		
		int speed = 0;
		int keyCode = 0;
		
		while (true) {
			if(keyCode != 13 && keyCode !=10) {
				if(keyCode == 49) {
					speed++;
				}else if(keyCode == 50) {
					speed--;
				}else if(keyCode == 51) {
					//break;
					System.exit(0);
				}
				System.out.println("---------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("---------------------");
				System.out.println("현재속도 = "+speed);
				System.out.println("선택");
			}
			
			try {
				keyCode = System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
