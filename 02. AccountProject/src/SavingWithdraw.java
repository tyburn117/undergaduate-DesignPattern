import java.util.Date;

public class SavingWithdraw implements WithdrawStrategy {

	private Date endDate;
	@SuppressWarnings("deprecation")
	@Override
	public int withdraw(int currentMoney, int money) {
		Date today = new Date();
		if(today.getYear() == endDate.getYear() && today.getMonth() == endDate.getMonth() && today.getDate() == endDate.getDate())
			return currentMoney - money;
		else
			return -1;
			
	}
	public SavingWithdraw(Date endDate){
		this.endDate = endDate;
	}

}
