package Day07.Ex3;

import java.io.FileOutputStream;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] 배열 = new String[3]; 	
		Member[] 배열2 = new Member[3];
		
		
		String id = scanner.next();
		String password = scanner.next();
		
		// 1.
		배열[0]=id +","+password; //아이디와 비밀번호를 쉼표로 구분해서 하나의 문자열 합치기
		
		System.out.println(배열[0].split(",")[0]);
		
		// 2. 회원 클래스를 이용하여 회원 객체를 만들자
		Member m1 = new Member();
		m1.id = id; m1.password = password;//입력받은 아이디를 객체 내 필드에 대입
		배열2[0]=m1; // 배열2에 m1 객체 대입. 효율성이 높다.
		
		System.out.println(배열2[0].id);
		
		
	}
}
