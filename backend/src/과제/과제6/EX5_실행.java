package 과제.과제6;

public class EX5_실행 {
	
	public static void main(String[] args) {
		// car 객체 생성
		Car car = new Car(); 
		
		// 1부터 10까지 1씩 증가하며 반복실행
		for( int i = 1 ; i<=10 ;i++ ) {
			int result =  car.run(); // Car 클래스의 run 메소드 실행
			// 각각의 결과에 따라 자동타입변환으로 새로운 타이어 대입
			if( result == 1 ) car.frontLeftTire = new HankookTire( 15 , "앞왼쪽" ); 
			if( result == 2 ) car.frontRightTire = new HankookTire( 13 , "앞오른쪽" );
			if( result == 3 ) car.backLeftTire = new KumhoTire( 14 , "뒤왼쪽" );
			if( result == 4 ) car.backRightTire = new KumhoTire( 17 , "뒤오른쪽" );
		} // for 
		
	}
}
