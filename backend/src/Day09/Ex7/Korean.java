package Day09.Ex7;
/*
	final :  최족적 뜻;
		- 수정 불가 만들기
		- 무조건 초기화가 있어야 한다.
		- 필드에 직접 초기화, 생성자 이용한 초기화
	
	static final 필드 : 상수
		- 수정 불가능, 공유 메모리
		- 상수 이름 : 관례적으로 대문자
 */


public class Korean {
	final String nation = "대한민국";
	final String ssn;
	
	String name;
	
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}	
		
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4*Math.PI*EARTH_RADIUS*EARTH_RADIUS;
	}
	
	
}
