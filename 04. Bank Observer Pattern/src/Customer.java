
public class Customer implements Observer {

	private Bank bank;
	private String name;
	public Customer(Bank bank,String name){
		this.bank = bank;
		this.name = name;
		bank.registerObserver(this);
	}
	@Override
	public void update(String message) {
		System.out.println("To : "+name+" msg : "+message);
	}
	
}
