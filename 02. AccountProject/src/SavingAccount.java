import java.util.Date;

public class SavingAccount extends Account{
	private Date endDate;
	
	public SavingAccount(Date endDate){
		super();
		this.endDate = endDate;
		super.setWithdrawStrategy(new SavingWithdraw(endDate));
	}
}
