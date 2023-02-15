package 과제.과제6;
public class Tire {
	// 1. 필드
	public int maxRotation; //최대회전수
	public int accumulatedRotation; //누적회전수 
	public String location; //바퀴의 위치
	
	//2. 생성자
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	//3. 메소드
	public boolean roll() { // true/false를 반환하는 형태의 메소드
		// 실행하면 누적 회전수 1증가
		++accumulatedRotation; 
		// 만약 누적회전수가 최대회전수보다 작으면 남아있는 타이어 수명(회전수) 출력 + true 반환
		if( accumulatedRotation < maxRotation ) { 
			System.out.println( location + " Tire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회"); 
			return true; 
		//만약 누적회전수가 최대회전수와 크거나 같으면 타이어 펑크 안내 + false 반환
		}else {
			System.out.println("*** " + location +" Tire 펑크 ***");
			return false; 
		}
	}
}
