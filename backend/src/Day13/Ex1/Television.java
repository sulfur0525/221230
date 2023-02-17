package Day13.Ex1;

public class Television implements RemoteControl{
	// 구현하다 : implement : 어떤 것을 구체적으로 나타나게 하다
		// -> 추상클래스를 구체적으로 나타나게 하다. 
		// 필수작업 : 추상메소드 구현
	
	// 1. 인터페이스 추상메소드를 구현
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	
}
