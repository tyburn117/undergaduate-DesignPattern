package Customer.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Account.Controller.AccountStateController;
import Account.Model.AccountModelInterface;
import Account.View.AccountAddView;
import Bank.Model.BankModelInterface;
import Customer.Model.CustomerModelInterface;
import Customer.View.CustomerStateView;

public class CustomerStateController extends WindowAdapter implements CustomerStateControllerInterface{
	private CustomerModelInterface customer;
	private BankModelInterface bank;
	private CustomerStateView view;
	
	public CustomerStateController(CustomerModelInterface customer,BankModelInterface bank){
		this.customer = customer;
		this.bank = bank;
		
		
		this.view = new CustomerStateView(this);
		customer.registerObserver(view);
		bank.registerObserver(view);
		view.createView();
		view.createControl();
		view.addWindowListener(this);
		
		updateList();
		view.setVisible(true);
	}
	
	private ArrayList<String> makeAccountsList(){
		ArrayList<String> list = new ArrayList<String>();
		for(AccountModelInterface a: customer.getAccounts()){
			list.add(a.toString());
		}
		return list;
	}
	@Override
	public void addAccount() {
		AccountAddView view = new AccountAddView(customer);
		view.setVisible(true);
	}

	@Override
	public void removeAccount(int idx) {
		customer.removeAccount(idx);
	}

	@Override
	public void viewDetailAccountState(int idx) {
		// TODO Auto-generated method stub
		
		AccountStateController controller = new AccountStateController(customer.getAccounts().get(idx));
		
	}

	@Override
	public void updateList() {
		this.view.setAccountsList(this.makeAccountsList());
	}

	@Override
	public void updateTotalMoney() {
		this.view.setMoneyLabel(customer.getTotalMoney());
	}
	
	@Override
	public void updateCustomerName(){
		this.view.setCustomersName(customer.getName());
	}
	public void windowClosing(WindowEvent e){
		CustomerStateView frame = (CustomerStateView)e.getWindow();
		customer.removeObserver(frame);
		bank.removeObserver(frame);
		frame.dispose();
	}

	@Override
	public void viewBankAlert() {
		JOptionPane.showMessageDialog(null, bank.getName()+"은행 : "+bank.getMessage(), customer.getName()+"님에게 보내는 메시지", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}
