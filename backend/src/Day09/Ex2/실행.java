package Day09.Ex2;

public class 실행 {
	public static void main(String[] args) {
		//1. 붕어빵 만들기
		// 스택영역 = 힙영역주소
		붕어빵틀 붕어빵1 = new 붕어빵틀();
		System.out.println(붕어빵1.toString());
		붕어빵1.굽기();
		
		붕어빵틀 붕어빵2 = new 붕어빵틀("반죽");
		System.out.println(붕어빵2.toString());
		붕어빵2.변경("반죽", "슈크림");
		System.out.println(붕어빵2.toString());
		
		붕어빵틀 붕어빵3 = new 붕어빵틀("반죽", "팥");
		System.out.println(붕어빵3.toString());
		int 판매가 = 붕어빵3.판매가();
		System.out.println(판매가);
		
		System.out.println("붕어빵4 판매 : "+붕어빵3.판매());
		
		붕어빵3.확인(붕어빵3);
		
		System.out.println(붕어빵3.여러개판매(5));
		
	}
}
