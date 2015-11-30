
public class Main {
	public static void main(String [] args){
		
		Account account = new NormalAccount(); 
		account.setMoney(10000);
		System.out.println(account.getMoney());
		
		account.withdraw(20000);
		System.out.println(account.getMoney());
		
		account.withdraw(3000);
		System.out.println(account.getMoney());
	}
}
