package Day02; // 현재 클래스가 존재하는 패키지

// ! : 자바는 무조건 class 단위 
	// 자바는 100% 객체지향 		// js : 함수단위 
	// 클래스 기반으로 메모리 할당 : 객체
	// 클래스 객체 설계도

public class Ex1_출력 {
	
	// * main 함수 : main 스레드 [스레드 : 작업 수행 주체]
	public static void main(String[] args) {
		// [ p.67 ] syso + 자동완성
		System.out.println();
			// System : 시스템 클래스 [ 관련 메소드 제공 ]
				// out : 출력 vs in : 입력
					// println() : 출력 후 줄바꿈 처리 [js : console.log]
					// print() : 출력
					// printf() : 형식 출력 
		// 2. print()
		System.out.print("print 함수1");
		System.out.print("print 함수2");
		// 3. println()
		System.out.println("println 함수1"); //출력 후 \n
		System.out.println("println 함수2");
		// 4. [p.69] printf("형식문자열" , 값)
			/*
			 	형식문자열
			 		%d : 정수
			 			%자릿수d 	: 오른쪽부터 자릿수 차지 [만일 자릿수에 데이터 없으면 공백]
			 			%-자릿수d	: 왼쪽부터 자릿수 차지 [만일 자릿수에 데이터 없으면 공백]
			 			%0자릿수d	: 오른쪽부터 자릿수 차지 [만일 자릿수에 데이터 없으면 0입력]
			 		%f : 실수
			 			%자릿수.소숫자릿수f
			 		%s : 문자열
			 */
		int value = 123;
		System.out.println("상품의 가격 : "+value+"원");
		System.out.printf("상품의 가격 : %d원", value); //출력 후 \n
		System.out.printf("상품의 가격 : %6d원", value);
		System.out.printf("상품의 가격 : %-6d원", value);
		System.out.printf("상품의 가격 : %06d원", value);
		
		double area = 3.14159; 
		System.out.println("파이출력 : "+area);
		System.out.printf("파이출력 : %f \n",area);
		System.out.printf("파이출력 : %.1f \n",area);
		System.out.printf("파이출력 : %3.2f \n",area);
		System.out.printf("파이출력 : %3.3f \n",area);
		System.out.printf("파이출력 : %3.4f \n",area);
		System.out.printf("파이출력 : %3.5f \n",area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n",1,name,job);
	}
}

/*
	String : 문자열 클래스
	System : 시스템 클래스
	
	제어 	/ 이스케이프 문자
		\n : 줄바꿈
		\t : 들여쓰기
		\" : " 출력
		\' : ' 출력
*/

















