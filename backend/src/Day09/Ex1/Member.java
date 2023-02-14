/*
 	클래스 용도 
 	1. 라이브러리 : 다른 클래스로부터 사용되는 클래스
 		협업에서 사용되는 디자인 패턴 : MVC
 		
 	2. 실행 클래스 : main 함수 가지고 있는 클래스
 	
 	-필두 사용
 		객체 내부 : 생성자, 메소드
 		객체 외부 : 객체명.필드명
 	
 */

package Day09.Ex1;

public class Member {
	
	//클래스 멤버
		//1. 필드
	String name;	// null
	int num;		// 0
	double num2;	// 0.0
	boolean cheak; 	// false
	String[] array = new String[3]; // null null null
	
		//2. 생성자
		//3. 메소드
	void setName() {
		String inputName; // 지역변수
		System.out.println(name);
		//System.out.println(inputName);
	}
	
	
	
}
