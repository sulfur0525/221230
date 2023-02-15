package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {
	public static void main(String[] args) {
		
		//1. 참조타입의 자동타입 변환
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HankookTire hankookTire = new HankookTire();
		
		Tire temp = tire;
			Tire temp2 = kumhoTire;
				Tire temp3 = hankookTire;
					Object temp4 = tire;
		
		// 2. 강제타입 변환
		Tire tire2 = (Tire) temp4;
			KumhoTire kumhoTire2 = (KumhoTire)tire2;
				HankookTire hankookTire2 = (HankookTire)tire2;
		
		// 3. 매개변수, 리턴타입
		Tire result = 함수1(kumhoTire2);
		KumhoTire result2 = (KumhoTire)함수2((KumhoTire)temp2);
		
		// 4. 배열, 리스트
		ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);
		kumhoList.add(hankookTire);
		kumhoList.add(tire);
		//----->
		ArrayList<Tire> tireList = new ArrayList<>();
		tireList.add(kumhoTire);
		tireList.add(hankookTire);
		tireList.add(tire);
	}
	
	public static KumhoTire 함수1(Tire tire) {return new KumhoTire();}
	public static Tire 함수1(KumhoTire kumhoTire) {return new Tire();}
	
}
