package 과제.과제9.클래스.연예인;

public class 실행 {
	public static void main(String[] args) {
		배우 배우 = new 배우("드라마", "영화", "연수입", "인지도");
		
		가수 가수 = new 가수("앨범", "연수입", "인지도");
		
		System.out.println(배우.toString());
		System.out.println(가수.toString());
	}
}
