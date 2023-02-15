package 과제.과제6;

public class Car {
	// 1. 필드 [ 변수 , 객체 , 상수 , 배열, 리스트 등 = 메모리 ]
	// Tire타입 객체 생성 & 생성자 호출
	Tire frontLeftTire = new Tire( 6 , "앞왼쪽"); // 최대회전수가 6인 왼쪽앞바퀴
	Tire frontRightTire = new Tire(2 , "앞오른쪽"); // 최대회전수가 2인 오른쪽앞바퀴
	Tire backLeftTire =  new Tire(3 , "뒤왼쪽"); // 최대회전수가 3인 왼쪽뒷바퀴
	Tire backRightTire =  new Tire(4 , "뒤오른쪽"); // 최대회전수가 4인 오른쪽뒷바퀴
	
	// 3. 메소드 
	// run()메소드 안에서 roll()메소드를 호출하여 받은 결과값에 따라 결과 리턴
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if( frontLeftTire.roll() == false ) { stop(); 	return 1; }
		if( frontRightTire.roll() == false ){ stop(); 	return 2; }
		if( backLeftTire.roll() == false ) 	{ stop(); 	return 3; }
		if( backRightTire.roll() == false ) { stop(); 	return 4; }
		return 0;
	}
	
	
	void stop() {System.out.println("[자동차가 멈춥니다.]");}
}
