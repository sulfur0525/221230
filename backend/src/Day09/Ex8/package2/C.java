package Day09.Ex8.package2;

import Day09.Ex8.package1.A;
import Day09.Ex8.package1.B;

public class C {
	//A a; // public 아니라서 import도 안됨
	B b; // import를 헤서 가능
	
	A a1 = new A(true);
	//A a2 = new A(1);
	//A a3 = new A("문자열"); 무조건 다른 클래스 사용 불가능
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1=10;
		//a4.field2=10;
		//a4.field3=10;
		
	}
	
}
