package 과제.과제7;

public class Kb extends Account{
	final String bankCode = "04";
	
	public Kb() {
		// TODO Auto-generated constructor stub
	}
	
	public Kb(String accountNumber, String accountPassword, String accountName, int accountMoney) {
		super(accountNumber,accountPassword,accountName,accountMoney);
	}
	
	@Override
	public boolean createAccount( String accountName, String accountPassword) {
		String accountNumber = bankCode+"-"+(Math.floor(Math.random() * 100) + 10)+
				"-"+(Math.floor(Math.random() * 100) + 10);
		Kb account = new Kb(accountNumber, accountPassword, accountName, accountMoney);
		accountDB.add(account);
		System.out.println("국민은행 계좌 만들어주셔서 감사합니다.");
		return true;
	}
	
}
