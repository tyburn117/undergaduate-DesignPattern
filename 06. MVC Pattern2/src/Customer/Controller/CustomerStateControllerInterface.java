package Customer.Controller;

import java.awt.event.WindowEvent;

public interface CustomerStateControllerInterface {
	void addAccount();
	void removeAccount(int idx);
	void viewDetailAccountState(int idx);
	void updateList();
	void updateTotalMoney();
	void updateCustomerName();
	void viewBankAlert();

	void windowClosing(WindowEvent e);
}
