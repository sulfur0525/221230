package Day09.Ex6;

public class 실행 {
	public static void main(String[] args) {
		
		Calculator mycal = new Calculator();
		System.out.println(mycal.no);
		mycal.getNo();
	
		System.out.println(Calculator.pi);
		double result1 = 10*10*Calculator.pi;
		Calculator.plus(10, 5);
		Calculator.minus(10, 5);
		
		System.out.println(Calculator.info);
		
		
	}
}
