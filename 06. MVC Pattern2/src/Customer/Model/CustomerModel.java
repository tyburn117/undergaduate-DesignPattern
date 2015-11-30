package Customer.Model;
import java.util.ArrayList;

import Account.AccountObserver;
import Account.Model.AccountModelInterface;
import Customer.CustomerObserver;

public class CustomerModel implements CustomerModelInterface,AccountObserver{	
	private String name;
	private ArrayList<AccountModelInterface> accounts;
	private ArrayList<CustomerObserver> observers;
	public CustomerModel(String name){
		this.name = name;
		this.accounts = new ArrayList<AccountModelInterface>();
		this.observers = new ArrayList<CustomerObserver>();
	}
	
	public String getName(){
		return name;
	}
	public String toString(){
		return "Name : "+name+ " ,total Money: "+getTotalMoney();
	}

	@Override
	public int getTotalMoney() {
		int sum= 0 ;
		for(AccountModelInterface account:accounts){
			sum += account.getMoney();
		}
		return sum;
	}

	@Override
	public void registerObserver(CustomerObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(CustomerObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(CustomerObserver observer:observers){
			observer.customerUpdate();
		}
	}

	@Override
	public void addAccount(AccountModelInterface account) {
		account.registerObserver(this);
		accounts.add(account);
		notifyObservers();
	}

	@Override
	public void removeAccount(AccountModelInterface account) {
		account.removeObserver(this);
		accounts.remove(account);
		notifyObservers();
	}

	@Override
	public void removeAccount(int idx) {
		removeAccount(accounts.get(idx));
	}
	
	@Override
	public ArrayList<AccountModelInterface> getAccounts() {
		return accounts;
	}

	

	@Override
	public void accountUpdate() {
		// TODO Auto-generated method stub
		notifyObservers();
	}
	
}
