package 과제.과제7;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("------------- 계좌 관리 ---------------");
			System.out.println("은행명	\t계좌번호\t\t예금액");
			
			for(Account a :Account.accountDB) {	
				if( a instanceof Kb ) {
					Kb kb = (Kb)a;
					System.out.println("국민\t\t"+kb.accountNumber+"\t"+kb.accountMoney);
				}else if( a instanceof Shinhan) {
					Shinhan shinhan = (Shinhan) a;
					System.out.println("신한\t\t"+shinhan.accountNumber+"\t"+shinhan.accountMoney);
				}else if( a instanceof Woori) {
					Woori woori = (Woori) a; 
					System.out.println("우리\t\t"+woori.accountNumber+"\t"+woori.accountMoney);
				}
			}
			
			System.out.println("메뉴 > 1.계좌생성 2.예금");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("------------- 계좌 생성 ---------------");
				System.out.println("1. 신한은행 2.국민은행 3.우리은행");
				int ch2 = scanner.nextInt();
				System.out.println("------------- 계좌 정보 입력  -----------");
				System.out.println("계좌주 :"); String accountName = scanner.next();
				System.out.println("계좌비밀번호 : "); String accountPassword = scanner.next();
				if(ch2==1) {
					Shinhan shinhan = new Shinhan();
					boolean result = shinhan.createAccount(accountName, accountPassword);
					if(result) {
						System.out.println("------------- 계좌 생성 완료  -----------");
						System.out.println("계좌주 : "+accountName);
						System.out.println("계좌번호 : "+Account.accountDB.get(Account.accountDB.size()-1).accountNumber);
						System.out.println("은행 : 신한");
					}
				}else if(ch2==2) {
					Kb kb = new Kb();
					boolean result = kb.createAccount(accountName, accountPassword);
					if(result) {
						System.out.println("------------- 계좌 생성 완료  -----------");
						System.out.println("계좌주 : "+accountName);
						System.out.println("계좌번호 : "+Account.accountDB.get(Account.accountDB.size()-1).accountNumber);
						System.out.println("은행 : 국민");
					}
				}else if(ch2==3) {
					Woori woori = new Woori();
					boolean result = woori.createAccount(accountName, accountPassword);
					if(result) {
						System.out.println("------------- 계좌 생성 완료  -----------");
						System.out.println("계좌주 : "+accountName);
						System.out.println("계좌번호 : "+Account.accountDB.get(Account.accountDB.size()-1).accountNumber);
						System.out.println("은행 : 신한");
					}
				}
			}else if(ch==2){
				System.out.println("----------- 계좌 입금 -----------------");
				System.out.println("입금할 계좌번호 :"); String accountNumber = scanner.next();
				System.out.println("예금액 :"); int accountMoney = scanner.nextInt();
				Account account = new Account();
				boolean result = account.deposit(accountNumber,accountMoney);
				if(result == true) {
					System.out.println("입금성공");
				}else {
					System.out.println("입금실패");
				}
				
			}
			
		}
		
		
		
	}
}
