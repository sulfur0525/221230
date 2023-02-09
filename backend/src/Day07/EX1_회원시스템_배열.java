package Day07;

import java.util.Scanner;

public class EX1_회원시스템_배열 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] memberList = new String[3]; 
		
		while (true) {
			
			System.out.println("번호[인덱스]\t회원명\t회원번호");
			for(int i = 0 ; i<memberList.length ; i++) {
				if(memberList[i]!=null) {
					String[] member = memberList[i].split(",");
					
					System.out.println(i+"\t"+member[0]+"\t"+member[1]);
				}
			}
			
			
			System.out.println("1.회원등록 2.회원삭제");
			int ch = scanner.nextInt();
			if( ch == 1) {
				System.out.println("회원명 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				
				for( int i = 0 ; i< memberList.length ; i++) {
					if(	memberList[i] == null) {
						memberList[i] = name + "," + phone;
						System.out.println(i+"번 회원이 등록되었습니다. 정보 : "+memberList[i]);
						break; 
					}
				}
			}else if( ch == 2) {
				
				System.out.println("삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				
				memberList[no]=null;
				
				for(int i = no ; i<memberList.length ; i++) {
					if(i+1==memberList.length) {memberList[i]=null; break;}
					memberList[i]=memberList[i+1];
					
					if(memberList[i+1]==null)break;
				}
				
			}else {
				
			}
			
		}
	}
}
