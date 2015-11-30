package Bank.Model;
import java.util.ArrayList;

import Bank.BankObserver;
import Customer.Model.CustomerModelInterface;

public interface BankModelInterface {
	String getName();
	ArrayList<CustomerModelInterface> getCustomers();
	void addCustomer(CustomerModelInterface c);
	void removeCustomer(CustomerModelInterface c);
	void removeCustomer(int idx);
	int totalMoney();
	
	void registerObserver(BankObserver o);  
	void removeObserver(BankObserver o);
	void notifyObservers();
	void sendMsgObservers();
	String getMessage();
	void alertMessage(String msg);
}
