package 과제.과제9.인터페이스.지문인식;

public class 잠금화면 implements 지문인식{

	@Override
	public void compare(String 지문) {
		if(지문.equals(지문인식.지문)) {
			System.out.println("지문이 일치하여 잠금이 해제됩니다.");
		}else {
			System.out.println("지문이 일치하지 않습니다.");
		}
	}
}
