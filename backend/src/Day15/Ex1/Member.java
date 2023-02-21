package Day15.Ex1;

public class Member {
	
	//1. 필드
	public  String id;
	
	//2. 생성자
	public Member(String id) {
		this.id = id;
	}
	
	//3. 메소드
	
	@Override
	public boolean equals(Object obj) {
		//if(obj instanceof Member target) { // jdk 16버전 이상에서 가능
			//부모객체 instanceod 자식클래스 변환객체명
			// obj -> target
		if(obj instanceof Member) {
			Member target = (Member)obj;
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
