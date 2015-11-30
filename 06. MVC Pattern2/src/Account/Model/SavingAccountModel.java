package Account.Model;

import java.util.Date;

import Account.InterestStrategy.InterestStrategy;
import Account.WithdrawStrategy.WithdrawStrategy;

public class SavingAccountModel extends AccountModel{

	private Date endDate;
	public SavingAccountModel(WithdrawStrategy withdrawStrategy, InterestStrategy interestStrategy, Date endDate) {
		super(withdrawStrategy, interestStrategy);
		// TODO Auto-generated constructor stub
		this.endDate = endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setEndDate(Date date){
		this.endDate = date;
	}
	public String toString(){
		return "적금계좌 ,돈 : "+getMoney();
	}
}
