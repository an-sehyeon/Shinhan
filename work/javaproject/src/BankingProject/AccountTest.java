package BankingProject;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.setBalance(100);
		System.out.println("현재 잔고 : " + acc.getBalance());
		
		acc.setBalance(-100);
		System.out.println("현재 잔고 : " + acc.getBalance());
		
		acc.setBalance(2000000);
		System.out.println("현재 잔고 : " + acc.getBalance());
		
		acc.setBalance(300000);
		System.out.println("현재 잔고 : " + acc.getBalance());
	}
}
