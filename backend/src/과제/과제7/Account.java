package 과제.과제7;

import java.util.ArrayList;

public class Account {
	// 1. 필드
	String accountNumber;
	String accountPassword;
	String accountName;
	int accountMoney;
	ArrayList<Account> accountDB = new ArrayList<>();
	
	// 2. 생성자
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, String accountPassword, String accountName, int accountMoney) {
		super();
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.accountName = accountName;
		this.accountMoney = accountMoney;
	}
	
	//3. 메소드
		//계좌만들기
	public boolean createAccount(String accountName, String accountPassword) {
		String bankCode = "";
		String accountNumber = bankCode+"-"+(Math.floor(Math.random() * 100) + 10)+
				"-"+(Math.floor(Math.random() * 100) + 10);
		Account account = new Account(accountNumber, accountPassword, accountName, 0);
		accountDB.add(account);
		System.out.println("계좌 만들어주셔서 감사합니다.");
		return true;
	}
	
	
		//예금
	public boolean deposit(String accountNumber, int accountMoney) {
		for(Account a : accountDB) {
			if(!a.accountNumber.equals(accountNumber)) {
				return false;
			}
			a.accountMoney+=accountMoney;
		}
		return true;
	}
	
	
	
	
	
}
