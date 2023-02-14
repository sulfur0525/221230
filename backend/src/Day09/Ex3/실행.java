package Day09.Ex3;

public class 실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5);
		
		if(myCar.ifLeftGas()) {
			System.out.println("출발합니다.");
		
			myCar.run();
		}
		
		System.out.println("gas를 주입하십시오.");
	}
}
