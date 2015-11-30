package Account.WithdrawStrategy;

public class MinusWithdraw implements WithdrawStrategy{

	/*
	 * 
	 * private int limitedMoney;
	
	public MinusWithdraw(int limitedMoney){
		this.limitedMoney = limitedMoney;
	}
	
	@Override
	public int withdraw(int currentMoney, int money) {
		if(currentMoney+limitedMoney >= money){			
			System.out.println("It's done");
			return currentMoney- money;
		}
		else{
			System.out.println("Can't withdraw");
			return -1;
		}
	}

	 */

	private int limitedMoney;
	
	public MinusWithdraw(int limitedMoney){
		this.limitedMoney = limitedMoney;
	}
	
	
	@Override
	public boolean withdraw(int currentMoney, int money) {
		if(currentMoney+limitedMoney >= money){			
			System.out.println("It's done");
			return true;
		}
		else{
			System.out.println("Can't withdraw");
			return false;
		}
	}

}
