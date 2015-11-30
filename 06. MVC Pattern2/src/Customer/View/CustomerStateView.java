package Customer.View;


import javax.swing.*;

import Bank.BankObserver;
import Customer.CustomerObserver;
import Customer.Controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
public class CustomerStateView  extends JFrame implements CustomerObserver,BankObserver,ActionListener{
	private final static String mText="금액 : ";

	private static final long serialVersionUID = 1L;
	private JLabel welcomeLabel;
	private JList<String> accountsList;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JLabel havedMoneyLabel;
	private JScrollPane scroller;
	private JPanel msgPanel = new JPanel();
	private JPanel listPanel = new JPanel();
	private JPanel functionsPanel = new JPanel();
	
	private JButton addAccount = new JButton("계좌추가");
	private JButton removeAccount = new JButton("계좌삭제");
	
	private CustomerStateControllerInterface controller;
	public CustomerStateView(CustomerStateControllerInterface controller){
		this.controller = controller;
	}
	public void createView(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLayout(new BorderLayout());
		add(msgPanel,BorderLayout.NORTH);
		add(listPanel,BorderLayout.CENTER);
		add(functionsPanel,BorderLayout.SOUTH);
		this.addWindowListener((WindowListener) controller);
	}
	public void createControl(){
		controller.updateCustomerName();
		havedMoneyLabel = new JLabel();
		accountsList = new JList<String>(listModel);
		controller.updateTotalMoney();
		
		
		scroller = new JScrollPane(accountsList);
		accountsList.setVisibleRowCount(10);;
		accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountsList.setFixedCellWidth(250);
		
		listPanel.add(scroller);
		msgPanel.add(welcomeLabel);
		msgPanel.add(havedMoneyLabel);
		functionsPanel.add(addAccount);
		functionsPanel.add(removeAccount);
		
		accountsList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				JList list = (JList)evt.getSource();
				if(evt.getClickCount()== 2){
					controller.viewDetailAccountState(list.locationToIndex(evt.getPoint()));
				}
			}
		});
		
		addAccount.addActionListener(this);
		removeAccount.addActionListener(this);
	}
	public void setAccountsList(ArrayList<String> list){
		listModel.clear();
		for(String l : list)
			listModel.addElement(l);
	}
	public void setMoneyLabel(int money){
		havedMoneyLabel.setText(mText+money);
	}
	public void setCustomersName(String name){
		this.setTitle(name+"님의 계좌관리 창");
		welcomeLabel = new JLabel(name+"님, 환영합니다!");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addAccount){
			controller.addAccount();
		}else if(e.getSource() == removeAccount){
			controller.removeAccount(accountsList.getSelectedIndex());
		}
	}

	@Override
	public void customerUpdate() {
		controller.updateList();
		controller.updateTotalMoney();
	}


	@Override
	public void bankUpdate() {
		
	}
	@Override
	public void sendMessage() {
		controller.viewBankAlert();
		
	}

}
