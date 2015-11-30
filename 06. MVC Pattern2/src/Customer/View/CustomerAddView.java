package Customer.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Customer.Controller.CustomerAddControllerInterface;
public class CustomerAddView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private CustomerAddControllerInterface controller;
	private JLabel msg = new JLabel("이름 : ");
	private JTextField nametext = new JTextField(10);
	
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	private JButton okBtn = new JButton("생성");
	public CustomerAddView(CustomerAddControllerInterface controller){
		this.controller = controller;
	}
	public void createView(){
		setSize(300,100);
		setLayout(new BorderLayout());
		add(topPanel,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
	}
	public void createControl(){
		topPanel.add(msg);
		topPanel.add(nametext);
		bottomPanel.add(okBtn);
		okBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okBtn){
			controller.addCustomer(nametext.getText());
			dispose();
		}
	}
	
}
