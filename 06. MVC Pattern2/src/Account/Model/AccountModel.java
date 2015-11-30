package Account.Model;

import java.util.ArrayList;

import Account.AccountObserver;
import Account.InterestStrategy.InterestStrategy;
import Account.WithdrawStrategy.WithdrawStrategy;

public class AccountModel implements AccountModelInterface {
	
	private int money;
	private ArrayList<AccountObserver> observers;
	private WithdrawStrategy withdrawStrategy;
	private InterestStrategy interestStrategy;
	
	
	public AccountModel(WithdrawStrategy withdrawStrategy, InterestStrategy interestStrategy){
		this.withdrawStrategy = withdrawStrategy;
		this.interestStrategy = interestStrategy;
		money = 0;
		observers = new ArrayList<AccountObserver>();
	}
	
	@Override
	public void registerObserver(AccountObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(AccountObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(AccountObserver observer:observers){
			observer.accountUpdate();
		}
	}

	@Override
	public int getMoney() {
		return money;
	}

	@Override
	public boolean deposit(int money) {
		this.money += money;
		notifyObservers();
		return true;
	}

	@Override
	public boolean withdraw(int money) {
		if(withdrawStrategy.withdraw(this.money, money)){
			this.money -= money;
			notifyObservers();
			return true;
		}
		else
			return false;
	}

	@Override
	public int getInterest(int afterMonth) {
		return interestStrategy.calculateInterest(this.money, afterMonth);
	}

	@Override
	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.withdrawStrategy = strategy;
		
	}

	@Override
	public void setInterestStrategy(InterestStrategy strategy) {
		this.interestStrategy = strategy;
	}

	public String toString(){
		return ""+money;
		
	}
}
