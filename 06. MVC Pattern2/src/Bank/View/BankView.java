package Bank.View;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import Bank.BankObserver;
import Bank.Controller.BankControllerInterface;

public class BankView extends JFrame implements BankObserver,ActionListener{
	private JLabel messageLabel= new JLabel("Msg :");
	private JTextField message = new JTextField(10);
	private JButton msgBtn = new JButton("Send");
	private JScrollPane scroller;
	private static final long serialVersionUID = 1L;
	
	private JPanel MsgPanel = new JPanel();
	private JPanel CustomerPanel = new JPanel();
	private JPanel CustomerControlPanel = new JPanel();
	private JList list;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	private JButton addCustomer = new JButton("고객추가");
	private JButton removeCustomer = new JButton("고객삭제");
	
	private BankControllerInterface controller;
	
	public BankView(BankControllerInterface controller){
		this.controller = controller;
	}
	public void createView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLayout(new BorderLayout());
		add(MsgPanel,BorderLayout.NORTH);
		add(CustomerPanel,BorderLayout.CENTER);
		add(CustomerControlPanel,BorderLayout.SOUTH);
	}
	public void createControl(){
		list = new JList(listModel);		
		
		
		scroller= new JScrollPane(list);
		
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellWidth(250);
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				JList list = (JList)evt.getSource();
				if(evt.getClickCount()== 2){
					controller.viewCustomer(list.locationToIndex(evt.getPoint()));
				}
			}
		});
		
		CustomerPanel.add(scroller);
		MsgPanel.add(messageLabel);
		MsgPanel.add(message);
		MsgPanel.add(msgBtn);
		CustomerControlPanel.add(addCustomer);
		CustomerControlPanel.add(removeCustomer);
		addCustomer.addActionListener(this);
		removeCustomer.addActionListener(this);
		msgBtn.addActionListener(this);
	}
	public void setBankName(String name){
		this.setTitle(name+"은행 관리창");
	}

	@Override
	public void bankUpdate() {
		controller.updateList();
		
	}
	public void setCustomersList(ArrayList<String> list){
		listModel.clear();
		for(String l : list)
			listModel.addElement(l);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addCustomer){ 
			System.out.println("누름 ");
			controller.addCustomer();
		}
		else if(e.getSource() == removeCustomer){
			controller.removeCustomer(list.getSelectedIndex());
		}
		else if(e.getSource() == msgBtn){
			controller.sendMessages(message.getText());
		}
	}
	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}
	
}
