package Customer.Model;
import java.util.ArrayList;

import Account.Model.AccountModelInterface;
import Customer.CustomerObserver;

public interface CustomerModelInterface {
	String toString();
	String getName();
	int getTotalMoney();
	void addAccount(AccountModelInterface account);
	void removeAccount(AccountModelInterface account);
	void removeAccount(int idx);
	ArrayList<AccountModelInterface> getAccounts();
	
	void registerObserver(CustomerObserver o);  
	void removeObserver(CustomerObserver o);
	void notifyObservers();
	
}
