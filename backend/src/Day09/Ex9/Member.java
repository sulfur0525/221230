package Day09.Ex9;

public class Member {
	private static Member member = new Member();
	
	private Member() {}
	
	public static Member getInstance() {//객체없이 호출하기 위해서 static 이어야 함. 
		return member;
	}
}
