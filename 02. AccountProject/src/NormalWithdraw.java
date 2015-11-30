
public class NormalWithdraw implements WithdrawStrategy {

	@Override
	public int withdraw(int currentMoney, int money) {
		if(currentMoney >= money){			
			System.out.println("It's done");
			return currentMoney - money;
		}
		else{
			System.out.println("Can't withdraw");
			return -1;
		}
	}

}
