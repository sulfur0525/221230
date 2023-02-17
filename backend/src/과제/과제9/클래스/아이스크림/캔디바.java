package 과제.과제9.클래스.아이스크림;

public class 캔디바 extends 아이스크림{
	String 막대기;
	
	public 캔디바() {
		// TODO Auto-generated constructor stub
	}

	public 캔디바(String 막대기,String 우유, String 설탕) {
		super(우유,설탕);
		this.막대기 = 막대기;
	}

	@Override
	public String toString() {
		return "캔디바 [막대기=" + 막대기 + ", 우유=" + 우유 + ", 설탕=" + 설탕 + "]";
	}
	
	
}
