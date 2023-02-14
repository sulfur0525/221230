package Day09.Ex9;

public class 실행 {
	public static void main(String[] args) {
		Member obj1 = Member.getInstance();
		Member obj2 = Member.getInstance();
		
		if(obj1==obj2) {
			System.out.println("같은 객체입니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
	}
}
