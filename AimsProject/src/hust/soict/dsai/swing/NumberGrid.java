package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Numger Grid");
		this.pack();
		setVisible(true);
	}
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		 for(int i = 1; i <= 9; i++) {
			 btnNumbers[i] = new JButton("" + i);
			 btnNumbers[i].setPreferredSize(new Dimension(70, 40));
			 panelButtons.add(btnNumbers[i]);
			 btnNumbers[i].addActionListener(btnListener);
		 }
		 
		 btnDelete = new JButton("DEL");
		 btnDelete.setPreferredSize(new Dimension(70, 40));
		 panelButtons.add(btnDelete);
		 btnDelete.addActionListener(btnListener);

		 btnNumbers[0] = new JButton("0");
		 btnNumbers[0].setPreferredSize(new Dimension(70, 40));
		 panelButtons.add(btnNumbers[0]);
		 btnNumbers[0].addActionListener(btnListener);

		 btnReset = new JButton("C");
		 btnReset.setPreferredSize(new Dimension(70, 40));
		 panelButtons.add(btnReset);
		 btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			
			else if(button.equals("DEL")) {
				if(!tfDisplay.getText().equals("")) {
					tfDisplay.setText(tfDisplay.getText().substring(0, tfDisplay.getText().length() - 1));
				}
			}
			
			else {
				tfDisplay.setText("");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new NumberGrid();
	}
}

