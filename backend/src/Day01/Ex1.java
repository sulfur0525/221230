/* 주석 */
	// 한줄주석 	 : 범위지정후 ctrl + / 
	/* 여러줄 주석  : 범위지정후 ctrl + shift + /	*/

package Day01;
/*
 * package : 패키지 이름이 표시되는 키워드
 * 	package 패키지명; : 현재 소스파일이 위치한 패키지명
 */


// 1. 자바는 클래스 { }안에서만 코드 작성해야한다. !!! 
	//int 변수 = 10; // 오류 발생 

public class Ex1 { // class start 

	int 변수 = 10; // class 안에서 코드 작성 가능 
	// 2. 실행되는 코드는 main함수{ } 안에서만 코드 작성한다. !!!
		// main함수 : 메인스레드 가지고 있는 함수
			// 스레드 : 코드를 읽어드리는 흐름 단위
		// m 입력후  ctrl+스페이바 -> 엔터 
	// System.out.println("안녕 자바"); // 오류발생
	
	public static void main(String[] args) {
		// 3. 출력 : syso입력후 ctrl+스페이바 -> 엔터
		System.out.println("안녕 자바"); // JS:console.log();
	}
	
} // class end 

/*
 * 	public	: 사용범위뜻 [ 프로젝트내 모든 곳 사용 ]
 * 	class	: 클래스 선언 사용되는 키워드
 * 	Ex1		: 클래스명[아무거나] 영문/첫글자 영대문자
 * 	{  }	: 클래스의 시작s 끝e
 */

/*
  
   실제 존재하는 모든것 --------------- > 코드
   	공기 , 돈 , 사람 등				객체지향 언어
   	[ 성질 , 행동 ]					 성질 , 행동
   	
   		예) 붕어빵 틀[클래스]
   			반죽[성질,속성]			붕어빵1[ 밀가루 , 팥] 
   			굽기[행동]				붕어빵2[ 밀가루 , 팥]
   									붕어빵3[ 밀카루 , 크림 ]
   									- 붕어빵 서로 다르다.
		예) SM7 자동차 틀[클래스]
			속도[성질,속성]			SM7 자동차1[ 50 , 주행중 ]						
			주행[행동]				SM7 자동차2[ 0 , 주행중X ] 
		
		예) 객체지향 프로그래밍 
			
			타이어 틀 : 금호타이어 회사 
				공기압			--> 타이어1 객체 / 타이어2 객체
				구르기	
				
			자동차 틀 [ 클래스 ] : 현대 회사
				- 타이어[ 금호타이어 객체 ]		-> 현대자동차
				
  
  	자바 100% 객체지향언어
  		클래스 : 객체 생성하기 위한 미리 정의된 틀/설계도
  		객체 : 클래스 기반으로 만들어진 식별가능한 형태/메모리
  		객체지향[ OOP ] : 객체들을 모아서 만든 프로그램 [ 레고 ]
  		
	코드 --> 프로세스 --> 프로그램
  		
*/

















