package Account.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;

import Account.AccountObserver;
import Account.Controller.AccountStateControllerInterface;

public class AccountStateView extends JFrame implements AccountObserver,ActionListener{
	
	private AccountStateControllerInterface controller;
	private JPanel remainMoneyPanel = new JPanel();
	private JPanel moneyPanel = new JPanel();
	private JPanel selectPanel =  new JPanel();
	private JLabel remainMoney;
	private JLabel moneyLabel = new JLabel("돈 : ");
	private JTextField moneyInput = new JTextField(10) ;
	private JButton depositBtn = new JButton("입금");
	private JButton withdrawBtn = new JButton("출금");
	
	public AccountStateView(AccountStateControllerInterface controller){
		this.controller = controller;
	}
	
	public void createView(){
		setSize(300,300);
		setLayout(new BorderLayout());

		add(remainMoneyPanel,BorderLayout.NORTH);
		add(moneyPanel,BorderLayout.CENTER);
		add(selectPanel,BorderLayout.SOUTH);
		
		this.addWindowListener((WindowListener) controller);
	}
	
	public void createControl(){
		createRemainMoneyPanel();
		createMoneyPanel();
		createSelectPanel();
	}
	private void createRemainMoneyPanel(){
		remainMoney = new JLabel();
		remainMoneyPanel.add(remainMoney);
	}
	private void createMoneyPanel(){
		moneyPanel.add(moneyLabel);
		moneyPanel.add(moneyInput);
	}
	private void createSelectPanel(){
		selectPanel.add(depositBtn);
		selectPanel.add(withdrawBtn);
		depositBtn.addActionListener(this);
		withdrawBtn.addActionListener(this);
	}
	public void updateRemainMoney(String msg){
		remainMoney.setText(msg);
	}
	
	@Override
	public void accountUpdate() {
		controller.updateMoney();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == depositBtn){
			controller.depositMoney(Integer.parseInt(moneyInput.getText()));
		}else if(e.getSource() == withdrawBtn){
			controller.withdrawMoney(Integer.parseInt(moneyInput.getText()));
		}
	}
	
	

}
