package Day11.Ex2;

public class Computer extends Calculator{
	// 오버라이딩 : 부모 클래스의 메소드를 재정의
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
