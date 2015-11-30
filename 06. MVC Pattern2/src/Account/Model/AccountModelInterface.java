package Account.Model;


import Account.AccountObserver;
import Account.InterestStrategy.InterestStrategy;
import Account.WithdrawStrategy.WithdrawStrategy;

public interface AccountModelInterface {
	void registerObserver(AccountObserver o);  
	void removeObserver(AccountObserver o);
	void notifyObservers();
	
	int getMoney();
	boolean deposit(int money); // 입금
	boolean withdraw(int money); //출금
	int getInterest(int afterMonth); //이자 계산
	
	void setWithdrawStrategy(WithdrawStrategy strategy);
	void setInterestStrategy(InterestStrategy strategy);
	
}
