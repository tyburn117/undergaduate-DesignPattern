package Account.WithdrawStrategy;

public class NormalWithdraw implements WithdrawStrategy{

	@Override
	public boolean withdraw(int currentMoney, int money) {
		
		if(currentMoney >= money){
			return true;
		}
		else
			return false;
	}

}
