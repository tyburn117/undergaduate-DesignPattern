package Bank.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import Bank.Model.BankModelInterface;
import Bank.View.BankView;
import Customer.Controller.CustomerAddController;
import Customer.Controller.CustomerStateController;
import Customer.Model.CustomerModelInterface;

public class BankController extends WindowAdapter implements BankControllerInterface {

	
	private BankModelInterface bank;
	private BankView view;
	public BankController(BankModelInterface bank){
		this.bank = bank;
		view = new BankView(this);
		bank.registerObserver(view);
		
		view.createView();
		view.createControl();
		view.setBankName(bank.getName());
		view.setVisible(true);
		
		
	}
	@Override
	public void addCustomer() {
		// TODO Auto-generated method stub
		new CustomerAddController(bank);
	}

	@Override
	public void removeCustomer(int idx) {
		bank.removeCustomer(idx);
	}
	@Override
	public void sendMessages(String msg) {
		bank.alertMessage(msg);
		
	}
	@Override
	public void viewCustomer(int idx) {
		// TODO Auto-generated method stub
		new CustomerStateController(bank.getCustomers().get(idx), bank);
	}
	public void windowClosing(WindowEvent e){
		BankView frame = (BankView)e.getWindow();
		bank.removeObserver(frame);
		frame.dispose();
	}
	@Override
	public void updateList() {
		// TODO Auto-generated method stub
		ArrayList<String> p = new ArrayList<String>();
		
		for(CustomerModelInterface c : bank.getCustomers()){
			p.add(c.toString());
		}
		
		view.setCustomersList(p);
	}

}
