package Day11.Ex4.package2;

import Day11.Ex4.package1.A;

public class D extends A{
	
	public D() {
		super();
	}
	
	public void method() {
		this.field = "value";
		this.method();
		
	}
	
	public void method2() {
		A a = new A(); //x
		a.field = "value";//x
		a.method();//x
	}
}
