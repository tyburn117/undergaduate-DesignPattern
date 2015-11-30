package Bank.Model;
import java.util.ArrayList;

import Bank.BankObserver;
import Customer.CustomerObserver;
import Customer.Model.CustomerModelInterface;

public class BankModel implements BankModelInterface,CustomerObserver{
	private String message;
	private String name;
	private ArrayList<CustomerModelInterface> customers;
	private ArrayList<BankObserver> bankObservers;
	public BankModel(String name){
		this.name = name;
		customers = new ArrayList<CustomerModelInterface>();
		bankObservers = new ArrayList<BankObserver>();
		
	}
	public String getName(){
		return name;
	}
	@Override
	public ArrayList<CustomerModelInterface> getCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}
	@Override
	public void addCustomer(CustomerModelInterface c) {
		// TODO Auto-generated method stub
		customers.add(c);
		c.registerObserver(this);
		notifyObservers();
	}
	@Override
	public int totalMoney() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void registerObserver(BankObserver o) {
		bankObservers.add(o);
		
	}
	@Override
	public void removeObserver(BankObserver o) {
		bankObservers.remove(o);
	}
	@Override
	public void notifyObservers() {
		for(BankObserver observer : bankObservers){
			observer.bankUpdate();
		}
	}
	@Override
	public void removeCustomer(int idx) {
		this.removeCustomer(customers.get(idx));
	}
	@Override
	public void removeCustomer(CustomerModelInterface c) {
		// TODO Auto-generated method stub
		customers.remove(c);
		c.removeObserver(this);
		notifyObservers();
	}
	@Override
	public String getMessage() {
		return message;
	}
	@Override
	public void alertMessage(String msg) {
		this.message = msg;
		sendMsgObservers();
	}
	@Override
	public void sendMsgObservers() {
		for(BankObserver observer : bankObservers){
			observer.sendMessage();
		}
	}
	@Override
	public void customerUpdate() {
		// TODO Auto-generated method stub
		notifyObservers();
	}
}
