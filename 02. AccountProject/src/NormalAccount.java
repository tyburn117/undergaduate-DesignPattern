
public class NormalAccount extends Account{
	
	public NormalAccount(){
		super();
		super.setWithdrawStrategy(new NormalWithdraw());
	}
	
	
}
