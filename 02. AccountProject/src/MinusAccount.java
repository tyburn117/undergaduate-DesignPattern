
public class MinusAccount extends Account{
	private int limitedMoney;
	
	public MinusAccount(int limitedMoney){
		super();
		this.limitedMoney = limitedMoney;
		super.setWithdrawStrategy(new MinusWithdraw(limitedMoney));
	}
	
	
}
