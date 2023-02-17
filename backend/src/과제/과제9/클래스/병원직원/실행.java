package 과제.과제9.클래스.병원직원;

public class 실행 {
	public static void main(String[] args) {
		의사 의사 = new 의사("진료", "회진", "당직" , "처방" , "이름" , "의사" , "월급" , "근무시간");
		System.out.println(의사.toString());
		
		간호사 간호사 = new 간호사("차팅", "환자케어", "비품관리", "이름", "간호사", "월급", "근무시간");
		System.out.println(간호사.toString());
		
		직원 직원 = new 직원("청소", "이름", "직업", "월급", "근무시간");
		System.out.println(직원.toString());
	}
}
