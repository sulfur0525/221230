package Day09.Ex8.package1;

public class B {
	A a; //같은 패키지 import 안해도 괜찮음 
	
	A a1 = new A(true);
	A a2 = new A(1);
	//A a3 = new A("문자열"); 무조건 다른 클래스 사용 불가능
	
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1=10;
		a4.field2=10;
		//a4.field3=10;
		
	}
	
	
}
