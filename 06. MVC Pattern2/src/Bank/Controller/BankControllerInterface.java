package Bank.Controller;

import java.awt.event.WindowEvent;

public interface BankControllerInterface {
	void addCustomer();
	void removeCustomer(int idx);
	void sendMessages(String msg);
	void viewCustomer(int idx);
	void windowClosing(WindowEvent e);
	void updateList();
}
