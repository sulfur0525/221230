package Day09.Ex6;

/*
	정적멤버  :
		1. static 키워드
		2. JVM 메소드 영역 저장
		3. 객체 없이 사용 가능
		4. 사용방법
			클래스명.정적멤버
		5. 프로그램 시작시 생성, 프로그램 종료시 초기화
			-모든 클래스에서 공통[공유]되는 메모리 사용
		6. 정적멤버는 인스턴스멤버 사용할 수 없다.
 */


public class Calculator {
	
	int no;
	
	static double pi = 3.14159;
	
	int getNo() {
		return no;
	}
	
	static int plus(int x,int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}
	
	static String info;
	static {
		info = pi+"파이입니다.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
