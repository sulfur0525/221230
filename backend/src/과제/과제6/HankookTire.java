package 과제.과제6;

public class HankookTire extends Tire {
	// 부모 생성자 호출
	// 부모 클래스에 기본생성자가 없고 매개변수를 가지는 생성자만 가지고 있으므로 super를 반드시 작성해야 한다.  
	public HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	// 부모의 메소드 재정의 -> 다형성
	// 부모 클래스와 거의 동일하지만 누적회전수가 최대회전수와 크거나 같으면 타이어 펑크 안내하는 상황에서 Tire가 HankookTire 로 바뀜 
	@Override
	public boolean roll() {
		++accumulatedRotation;	
		if( accumulatedRotation < maxRotation ) {
			System.out.println( location + " HankookTire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" HankookTire 펑크 ***");
			return false; 
		}
	}
	
	
}
