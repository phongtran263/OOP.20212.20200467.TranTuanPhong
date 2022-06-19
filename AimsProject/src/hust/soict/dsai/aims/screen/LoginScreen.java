package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.store.Store;

public class LoginScreen extends JFrame{
	private Store store;
	
	public LoginScreen(Store store) {
		this.store = store;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		Container cp = getContentPane();
		
		JRadioButton customerBtn = new JRadioButton("Customer");
		JRadioButton managerBtn = new JRadioButton("Manager");
		customerBtn.setBounds(140, 40, 120, 30);
		managerBtn.setBounds(140, 90, 120, 30);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(customerBtn);
		bg.add(managerBtn);
		customerBtn.setSelected(true);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(140, 140, 120, 30);
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(managerBtn.isSelected()) {
					dispose();
					new StoreManagerScreen(store);
				}
			}
			
		});
		
		cp.add(customerBtn);
		cp.add(managerBtn);
		cp.add(loginBtn);
		
		setTitle("Login");
		setSize(400, 250);
		
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
