package Account.Controller;

import java.awt.Event;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import Account.Model.*;
import Account.View.AccountStateView;

public class AccountStateController extends WindowAdapter implements AccountStateControllerInterface{

	private AccountModelInterface account;
	private AccountStateView view;
	
	public AccountStateController(AccountModelInterface account){
		this.account = account;
		
		this.view = new AccountStateView(this);
		account.registerObserver(this.view);
		this.view.createView();
		this.view.createControl();
		updateMoney();
		this.view.setVisible(true);
	}
	
	@Override
	public void updateMoney() {
		view.updateRemainMoney("<html>"+"현재 돈 :"+account.getMoney()+"<br>1년 후: "+account.getInterest(12)+"<br>2년 후: "+account.getInterest(24)+"<br>5년 후 : "+account.getInterest(60)+"</html>");
	}
	public void windowClosing(WindowEvent e){
		AccountStateView frame = (AccountStateView)e.getWindow();
		account.removeObserver(frame);
		frame.dispose();
	}

	@Override
	public void withdrawMoney(int money) {
		if(!account.withdraw(money)){
			JOptionPane.showMessageDialog(null, "돈을 뺄 수 없습니다. ", "출금 실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void depositMoney(int money) {
		// TODO Auto-generated method stub
		account.deposit(money);
	}
}
