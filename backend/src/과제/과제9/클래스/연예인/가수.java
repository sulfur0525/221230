package 과제.과제9.클래스.연예인;

public class 가수 extends 연예인{
	String 앨범;
	
	public 가수() {
		// TODO Auto-generated constructor stub
	}

	public 가수(String 앨범,String 연수입, String 인지도) {
		super(연수입, 인지도);
		this.앨범 = 앨범;
	}

	@Override
	public String toString() {
		return "가수 [앨범=" + 앨범 + ", 연수입=" + 연수입 + ", 인지도=" + 인지도 + "]";
	}
	
	
	
	
}
