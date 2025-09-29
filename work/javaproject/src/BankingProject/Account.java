package BankingProject;

public class Account {
	
	private String accNo;
	private String owner;
	private int balance;
	
	int min = AccountEnum.MIN_BALANCE.getAmount();
	int max = AccountEnum.MAX_BALANCE.getAmount();
	
	public Account(){
		this(null,null,0);
	}
	
	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	

	@Override
	public String toString() {
		return "계좌 [계좌번호=" + accNo + ", 예금주=" + owner + ", 잔액=" + balance + "원]";
	}
	
	public void deposit(int amount) {
		this.balance+=amount;
	}
	

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}
	
	public String getAccNo() {
		return accNo;
	}

	public void setBalance(int balance) {
		if(balance >= min && balance <= max) {
			this.balance += balance;
		}
	}
	


}
