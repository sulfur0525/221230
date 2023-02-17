package Day13.Ex4;

public class 실행 {
	public static void main(String[] args) {
		InterfaceCImpl impl = new InterfaceCImpl();
		InterfaceA ia = impl;
		ia.methodA();
		
		interfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
