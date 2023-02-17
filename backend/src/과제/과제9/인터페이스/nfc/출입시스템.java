package 과제.과제9.인터페이스.nfc;

public class 출입시스템 implements nfc{

	@Override
	public void nfcOn() {
		System.out.println("출입인증을 위해 nfc가 켜집니다.");
	}

	@Override
	public void nfcOff() {
		System.out.println("출입인증이 끝나 nfc가 꺼집니다.");
	}

}
