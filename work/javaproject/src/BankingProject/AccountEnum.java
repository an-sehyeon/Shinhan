package BankingProject;

public enum AccountEnum {
	MIN_BALANCE(0),MAX_BALANCE(1000000);
	
	int amount;
	
	AccountEnum(int amount){
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	
	

}
