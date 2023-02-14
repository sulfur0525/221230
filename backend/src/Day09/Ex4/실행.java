package Day09.Ex4;

public class 실행 {
	public static void main(String[] args) {
		Calculator myCalcu = new Calculator();
		
		double result1 = myCalcu.areaRectangle(10);
		
		double result2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이 = "+result1);
		System.out.println("직사각형 넓이 = "+result2);
	}
}
