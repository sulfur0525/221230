package Day15.Ex3;

public class 실행 {
	public static void main(String[] args) {
		
		SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");
		
		String srtObj = myPhone.toString();
		System.out.println(srtObj);
		
		System.out.println(myPhone);
	}
}
