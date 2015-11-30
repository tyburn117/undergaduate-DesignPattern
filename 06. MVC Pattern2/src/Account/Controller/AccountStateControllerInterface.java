package Account.Controller;

import java.awt.event.WindowEvent;

public interface AccountStateControllerInterface {
	void withdrawMoney(int money);
	void depositMoney(int money);
	void updateMoney();
	void windowClosing(WindowEvent e);
}
