package Day07.Ex5;

import java.util.ArrayList;
import java.util.Arrays;

import Day07.Ex5.Member;

public class 실행 {
	public static void main(String[] args) {
		
		//객체 3개
		Member m1 = new Member();
		m1.id = "qwe"; m1.password ="qwe";
				
		Member m2 = new Member();
		m1.id = "qwe"; m1.password ="qwe";
		
		Member m3 = new Member();
		m1.id = "qwe"; m1.password ="qwe";
		
		//1.배열[언어 문법, 프로그래밍 언어] 고정길이
		Member[] memberList1 = new Member[3]; 
		memberList1[0]=m1;
		memberList1[1]=m2;
		memberList1[2]=m3;
		
		System.out.println(Arrays.toString(memberList1));
		memberList1[1]=null;
		System.out.println(Arrays.toString(memberList1));
		
		//2. 컬렉션[수집] 프레임워크[미리 만들어진 클래스] 가변길이
		ArrayList<Member> memberList2 = new ArrayList<>();
		memberList2.add(m1);
		memberList2.add(m2);
		memberList2.add(m3);
		
		
		System.out.println(memberList2);
		memberList2.remove(1);
		System.out.println(memberList2);
		
	
		
		
	}
}
