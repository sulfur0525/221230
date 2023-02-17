package 과제.과제9.인터페이스.nfc;

public class 삼성페이 implements nfc{

	@Override
	public void nfcOn() {
		System.out.println("결제를 위해 nfc를 켭니다.");
	}

	@Override
	public void nfcOff() {
		System.out.println("결제가 끝나 nfc를 끕니다.");
	}

}
