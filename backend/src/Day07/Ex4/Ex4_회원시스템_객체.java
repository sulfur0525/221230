package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_객체 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member[] memberList = new Member[3];
		
		while (true) {
			System.out.println("번호[인덱스]\t회원명\t회원번호");
			for(int i = 0 ; i<memberList.length ; i++) {
				if(memberList[i]!=null) {
					System.out.println(i+"\t"+
								memberList[i].name+"\t"+
								memberList[i].phone);
				}
			}
			
			
			System.out.println("1.회원등록 2.회원삭제");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("회원명 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				
				for( int i = 0 ; i< memberList.length ; i++) {
					if(	memberList[i] == null) {
						//[ x ] name + "," + phone <- 효율성이 떨어짐
						//[ o ] 객체 만들기
						Member member = new Member();
						member.name = name;
						member.phone = phone;
						memberList[i]=member;
						break;
					}
				}
			}else if(ch==2) {
				
			}
			else {}
			
		}
	}
}
