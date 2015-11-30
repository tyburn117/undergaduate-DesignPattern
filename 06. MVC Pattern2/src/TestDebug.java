
import Bank.Controller.BankController;
import Bank.Model.BankModel;

public class TestDebug {
	public static void main(String [] args){
		
		new BankController(new BankModel("하나"));
		
	}
}
