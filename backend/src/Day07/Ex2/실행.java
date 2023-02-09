//실행

package Day07.Ex2;

public class 실행 {
	public static void main(String[] args) {
		//1. 클래스를 이용한 객체 생성
		Car mycar = new Car();
		// 클래스명 변수명 = new 생성자명();
		
		//2. 객체의 필드값 호출[.접근연산자]
		System.out.println("모델명 : " + mycar.model);
		System.out.println("시동여부 : " + mycar.start);
		System.out.println("현재속도 : " + mycar.speed);
	
		//3.
		Car yourCar = new Car();
		
		yourCar.model = "현대자동차";
		
		System.out.println("mycar모델명 : " + mycar.model);
		System.out.println("yourCar모델명 : " + yourCar.model);
		
	}
}
