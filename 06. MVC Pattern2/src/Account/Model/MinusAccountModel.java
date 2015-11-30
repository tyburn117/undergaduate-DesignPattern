package Account.Model;

import Account.InterestStrategy.InterestStrategy;
import Account.WithdrawStrategy.WithdrawStrategy;

public class MinusAccountModel extends AccountModel{
	private int limitedMoney;
	public MinusAccountModel(WithdrawStrategy withdrawStrategy, InterestStrategy interestStrategy, int limitedMoney) {
		super(withdrawStrategy, interestStrategy);
		this.limitedMoney = limitedMoney;
	}
	public int getLimitiedMoney(){
		return this.limitedMoney;
	}
	public void setLimitedMoney(int money){
		this.limitedMoney = money;
	}
	public String toString(){
		return "마이너스계좌, 돈 :"+getMoney();
	}
}
