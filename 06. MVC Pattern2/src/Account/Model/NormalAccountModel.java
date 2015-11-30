package Account.Model;

import Account.InterestStrategy.InterestStrategy;
import Account.WithdrawStrategy.WithdrawStrategy;

public class NormalAccountModel extends AccountModel{

	public NormalAccountModel(WithdrawStrategy withdrawStrategy, InterestStrategy interestStrategy) {
		super(withdrawStrategy, interestStrategy);
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return "일반계좌, 돈 :"+getMoney();
	}
}
