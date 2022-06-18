package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame{
	public LookAndFeelDemo() {
		addDemoComponent();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	
	void addDemoComponent() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length + 2];
		for(int i = 0; i < lafInfos.length; i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		lafNames[lafInfos.length] = "Java";
		lafNames[lafInfos.length + 1] = "System";
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					if(index == lafInfos.length) {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}
					else if(index == lafInfos.length + 1) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					else {
						UIManager.setLookAndFeel(lafInfos[index].getClassName());
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				if(index == lafInfos.length) {
					setTitle("Java Look And Feel");
				}
				else if(index == lafInfos.length + 1) {
					setTitle("System Look And Feel");
				}
				else {
					setTitle(lafInfos[index].getName() + "Look And Feel");
				}
			}
			
		});
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}
