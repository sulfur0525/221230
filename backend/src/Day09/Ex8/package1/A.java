package Day09.Ex8.package1;

/*
 	접근제한자 : 해당 클래스, 핑드, 생성자, 메소드 접근을 제한하는 키워드
 	
 	
 */
public class A {
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public A(boolean b) {}
	A(int b){}
	private A(String s) {}
	
	public int field1;
	int field2;
	private int field3;
	
	
}
