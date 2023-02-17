package 과제.과제9.클래스.연예인;

public class 배우 extends 연예인{
	String 드라마;
	String 영화;
	
	public 배우() {
		// TODO Auto-generated constructor stub
	}

	public 배우(String 드라마, String 영화, String 연수입, String 인지도) {
		super(연수입,인지도);
		this.드라마 = 드라마;
		this.영화 = 영화;
	}

	@Override
	public String toString() {
		return "배우 [드라마=" + 드라마 + ", 영화=" + 영화 + ", 연수입=" + 연수입 + ", 인지도=" + 인지도 + "]";
	}
	
	
}
