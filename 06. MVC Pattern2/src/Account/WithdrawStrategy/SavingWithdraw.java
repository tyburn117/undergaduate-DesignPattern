package Account.WithdrawStrategy;

import java.util.Date;

public class SavingWithdraw implements WithdrawStrategy{
	private Date endDate;
	public SavingWithdraw(Date endDate){
		this.endDate = endDate;
	}
	@Override
	public boolean withdraw(int currentMoney, int money) {
		Date today = new Date();
		if(today.getYear() == endDate.getYear() && today.getMonth() == endDate.getMonth() && today.getDate() == endDate.getDate())
			return true;
		else
			return false;
	}

}
