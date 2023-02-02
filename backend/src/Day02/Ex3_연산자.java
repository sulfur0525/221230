package Day02;

public class Ex3_연산자 {
	public static void main(String[] args) {
		
		// 1. 부호/증감연산자 [p.78]
		int x = +10;
		int y = -10;
		System.out.println(x);
		System.out.println(y);
		
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);
		
		System.out.println(y--);
		System.out.println(y);
		System.out.println(--y);
		
		// 2. 산술연산자 [p.81]
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		System.out.println(x%y);
		
		// 3. 비교연산자 [p.88]
		System.out.println(x==y);
		System.out.println(x!=y);
		System.out.println(x>y);
		System.out.println(x>=y);
		System.out.println(x<y);
		System.out.println(x<=y);
		
		System.out.println("유재석".equals("유재석"));
		System.out.println(!"유재석".equals("유재석"));
		
		// 4. 논리연산자 [p.91]
		System.out.println(x>5 && x<20);
		System.out.println(x>5 && x<10);
		System.out.println(0<=x || x>=20);
		System.out.println(0<=x || x>=10);
		
		// 5. 대입연산자 [p.102]
		int z = 30; 
		z += x;
		System.out.println(z);
		z -= x; z *= x; z /= x; z %= x;
		
		// 6. 삼항연산자 [p.103]
		String 결과 = (x>=20) ? "합격" : "불합격";
		System.out.println(결과);
		
		// 7. 연결연산자
		String 연결문자 = "유재석"+"10";
		String 연결문자2 = "유재석" + 10;
		String 연결문자3 = "유재석"+ 10 + 20;
		String 연결문자4 = "유재석"+ (10 + 20);
	}
}
