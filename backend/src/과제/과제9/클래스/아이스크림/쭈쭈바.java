package 과제.과제9.클래스.아이스크림;

public class 쭈쭈바 extends 아이스크림{
	String 쭈쭈바용기;
	
	public 쭈쭈바() {
		// TODO Auto-generated constructor stub
	}

	public 쭈쭈바(String 쭈쭈바용기, String 우유, String 설탕) {
		super(우유, 설탕);
		this.쭈쭈바용기 = 쭈쭈바용기;
	}

	@Override
	public String toString() {
		return "쭈쭈바 [쭈쭈바용기=" + 쭈쭈바용기 + ", 우유=" + 우유 + ", 설탕=" + 설탕 + "]";
	}
	
	
}
