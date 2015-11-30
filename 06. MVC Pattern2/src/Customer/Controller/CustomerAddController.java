package Customer.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Bank.Model.BankModelInterface;
import Customer.Model.CustomerModel;
import Customer.View.CustomerAddView;

public class CustomerAddController extends WindowAdapter implements CustomerAddControllerInterface{

	BankModelInterface bank;
	CustomerAddView view;
	public CustomerAddController(BankModelInterface bank){
		this.bank = bank;
		this.view = new CustomerAddView(this);
		System.out.println("실행");
		view.createView();
		view.createControl();
		view.setVisible(true);
	}
	
	@Override
	public void addCustomer(String name) {
		bank.addCustomer(new CustomerModel(name));
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
