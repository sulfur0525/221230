package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		myCar.tire = new Tire();
		myCar.run();
		
		myCar.tire = new HankookTire();
		myCar.run();
		
		myCar.tire = new KumhoTire();
		myCar.run();
		
		
		
	}
}
