package Day04;

import java.util.Scanner;

public class Ex2_예금 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int balance = 0;
		String account = "123-1234";
		short password = 1234;
		
		while(true) {
			System.out.println("-----------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("-----------------");
			System.out.println(" >> 선택 : ");
			
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println(" >>예금할 계좌번호 : ");
				String inaccount = scanner.next();
				if(account.equals(inaccount)) {
					System.out.println(" >> 예금할 금액 : ");
					balance +=scanner.nextInt();
					System.out.println(" >>예금 후 금액 : "+balance);
				}else {
					System.out.println("없는 계좌번호 입니다.");
				}
			}else if(ch==2) {
				System.out.println(" >>예금할 계좌번호 : ");
				String inaccount = scanner.next();
				if(account.equals(inaccount)) {
					System.out.println(" >> 계좌 비밀번호");
					Short inpassword = scanner.nextShort();
					if(inpassword==password) {
						System.out.println(" >> 출금할 금액 : ");
						int out = scanner.nextInt();
						
						if(out>balance) {
							System.out.println("잔액이 부족합니다." +balance);
						}else {
							balance -=scanner.nextInt();
							System.out.println(" >>출금 후 금액 : "+balance);
						}
					}else {
						System.out.println("틀린 비밀번호 입니다.");
					}
				}else {
					System.out.println("없는 계좌번호 입니다.");
				}
			}else if(ch==3) {
				System.out.println(" >>잔고 : "+balance);
			}else if(ch==4) {
				System.out.println(" >> 종료");
				break;
			}else {
				System.out.println("알 수 없는 번호입니다. 다시 입력해 주세요.");
			}
		}
		
	}
}
