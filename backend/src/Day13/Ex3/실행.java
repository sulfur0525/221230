package Day13.Ex3;

public class 실행 {
	public static void main(String[] args) {
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		Searchable s = new SmartTelevision();
		s.search("www.naver.com");
	}
}
