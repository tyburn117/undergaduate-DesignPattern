package Account.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import java.awt.*;
import javax.swing.*;

import Account.InterestStrategy.*;
import Account.Model.*;
import Account.WithdrawStrategy.*;
import Customer.Model.CustomerModelInterface;

public class AccountAddView extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private String[] accountList ={"NormalAccount","MinusAccount","SavingAccount"};
	private CustomerModelInterface customer;
	private JComboBox<String> accountCombo;
	private JLabel accMsg = new JLabel("계좌종류 : ");
	private JLabel minusMsg = new JLabel("한도액 : ");
	private JLabel savingMsg = new JLabel("만기일 : ");
	private JTextField minusfield = new JTextField(10);
	private JTextField savingfield = new JTextField(10);
	private JButton okBtn = new JButton("확인");
	private JButton cancelBtn = new JButton("취소");
	
	private JPanel accountPanel=new JPanel();
	private JPanel optPanel = new JPanel();
	private JPanel selectPanel = new JPanel();
	
	
	public AccountAddView(CustomerModelInterface customer){
		this.customer = customer;
		accountCombo = new JComboBox<String>(accountList);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		accountPanel.add(accMsg);
		accountPanel.add(accountCombo);
		
		selectPanel.add(okBtn);
		selectPanel.add(cancelBtn);
	
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		accountCombo.addActionListener(this);
		
		setSize(300,150);
		setLayout(new BorderLayout());
	
		
		add(accountPanel,BorderLayout.NORTH);
		add(optPanel,BorderLayout.CENTER);
		add(selectPanel,BorderLayout.SOUTH);
		this.setTitle("일반계좌");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn){
			dispose();
		}
		else if(e.getSource() == okBtn){
			if(accountCombo.getSelectedIndex() == 0){
				customer.addAccount(new NormalAccountModel(new NormalWithdraw(), new NormalInterest() ));
			}else if(accountCombo.getSelectedIndex() == 1){
				customer.addAccount(new MinusAccountModel(new MinusWithdraw(Integer.parseInt(minusfield.getText())), new MinusInterest(),Integer.parseInt(minusfield.getText())));
			}else if(accountCombo.getSelectedIndex() == 2){
				customer.addAccount(new SavingAccountModel(new SavingWithdraw(new Date()), new SavingInterest(), new Date()));
			}
			
			dispose();
		}
		else if(e.getSource() == accountCombo){
			System.out.println("select");
			
			optPanel.remove(minusMsg);
			optPanel.remove(savingMsg);
			optPanel.remove(minusfield);
			optPanel.remove(savingfield);
			if(accountCombo.getSelectedIndex() == 0){
				this.setTitle("일반계좌");
				System.out.println("일반");
			}else if(accountCombo.getSelectedIndex() == 1){
				this.setTitle("마이너스계좌");
				optPanel.add(minusMsg);
				optPanel.add(minusfield);
				System.out.println("마이너스");
			}
			else if(accountCombo.getSelectedIndex() == 2){
				this.setTitle("적금계좌");
				optPanel.add(savingMsg);
				optPanel.add(savingfield);
			}
			optPanel.revalidate();
			optPanel.repaint();
			this.repaint();
		}
	}

}
