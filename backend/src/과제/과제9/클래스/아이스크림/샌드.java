package 과제.과제9.클래스.아이스크림;

public class 샌드 extends 아이스크림{
	String 쿠키;
	
	public 샌드() {
		// TODO Auto-generated constructor stub
	}

	public 샌드(String 쿠키, String 우유, String 설탕) {
		super(우유, 설탕);
		this.쿠키 = 쿠키;
	}

	@Override
	public String toString() {
		return "샌드 [쿠키=" + 쿠키 + ", 우유=" + 우유 + ", 설탕=" + 설탕 + "]";
	}
	
	
}
