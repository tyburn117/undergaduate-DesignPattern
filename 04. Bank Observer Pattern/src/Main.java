
public class Main {

	public static void main(String[] args) {

		Bank hana = new Bank();
		
		Customer a = new Customer(hana,"a");
		Customer b = new Customer(hana,"b");
		Customer c = new Customer(hana,"c");
		
		hana.notifyMessage("안녕하세요 하나 은행입니다.");
	}

}
