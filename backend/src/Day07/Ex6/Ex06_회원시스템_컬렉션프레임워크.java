package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex06_회원시스템_컬렉션프레임워크 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> memberList = new ArrayList<>();
			//리스트선언<자료형/클래스>
		
		while (true) {
			System.out.println("번호[인덱스]\t회원명\t회원번호");
			/*memberList.forEach(( o ) ->{
				System.out.println(o);
			});
			}*/
			for(int i = 0 ; i<memberList.size();i++) {
				System.out.println(i+"\t"+memberList.get(i).name+"\t"+memberList.get(i).phone);
			}
			
			System.out.println("1.회원등록 2.회원삭제");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("회원명 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				
				
					//[ x ] name + "," + phone <- 효율성이 떨어짐
					//[ o ] 객체 만들기
					Member member = new Member();
					member.name = name;
					member.phone = phone;
					memberList.add(member);
	
			}else if(ch==2) {
				System.out.println("삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				memberList.remove(no);
			}
			else {}
		
		}
	}
}
	

