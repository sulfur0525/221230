package 과제.과제7;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("------------- 계좌 관리 ---------------");
			System.out.println("은행명	\t계좌번호\t예금액");
			for(Account a :Account.accountDB) {
				String bankName = "";
				if(a.accountNumber.split("-")[0].equals("03")) {
					bankName = "신한";
				}else if(a.accountNumber.split("-")[0].equals("04")) {
					bankName = "국민";
				}else if(a.accountNumber.split("-")[0].equals("05")) {
					bankName = "우리";
				}
				System.out.println(bankName+"\t"+a.accountNumber+"\t"+a.accountMoney);
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
				
			}
			
		}
		
		
		
	}
}
