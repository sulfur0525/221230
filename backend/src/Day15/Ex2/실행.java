package Day15.Ex2;

public class 실행 {
	public static void main(String[] args) {
		
		System.out.println("자바".hashCode());
		System.out.println("자바".hashCode());
		System.out.println("자바".hashCode()=="자바".hashCode());
		
		Student s1 = new Student(1, "홍길동");
			System.out.println(s1);
		Student s2 = new Student(2, "홍길동");
			System.out.println(s2);
	
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	System.out.println(s2.hashCode()==s1.hashCode());
	
	}
}	
