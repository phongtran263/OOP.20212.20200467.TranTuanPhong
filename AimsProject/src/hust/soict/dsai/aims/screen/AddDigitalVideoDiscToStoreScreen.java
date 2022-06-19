package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame implements ActionListener {
	private Store store;
	private JMenu smUpdateStore;
	private JMenuItem addBook;
	private JMenuItem addDVD;
	private JMenuItem addCD;
	private JMenuItem viewStore;
	private JMenuItem Logout;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		this.store = store;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(7, 2, 1, 1));	
		
		JLabel lb1 = new JLabel("Enter title: ");
		panel.add(lb1);
		JTextField title = new JTextField();
		title.setEditable(false);
		panel.add(title);
		
		JLabel lb2 = new JLabel("Enter category: ");
		panel.add(lb2);
		JTextField category = new JTextField();
		category.setEditable(false);
		panel.add(category);
		
		JLabel lb3 = new JLabel("Enter director: ");
		panel.add(lb3);
		JTextField director = new JTextField();
		director.setEditable(false);
		panel.add(director);
		
		JLabel lb4 = new JLabel("Enter length: ");
		panel.add(lb4);
		JTextField length = new JTextField();
		length.setEditable(false);
		panel.add(length);
		
		JLabel lb5 = new JLabel("Enter cost: ");
		panel.add(lb5);
		JTextField cost = new JTextField();
		cost.setEditable(false);
		panel.add(cost);
		
		String[] addingOptions = new String[] {"title", "title, category, cost", "title, category, director, cost", "title, category, director, length, cost"};
		JComboBox addingOptionscb = new JComboBox(addingOptions);
		addingOptionscb.setSelectedIndex(-1);
		addingOptionscb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = addingOptionscb.getSelectedIndex();
				if(index == 0) {
					title.setEditable(true);
					category.setEditable(false);
					director.setEditable(false);
					length.setEditable(false);
					cost.setEditable(false);
				}
				else if(index == 1) {
					title.setEditable(true);
					category.setEditable(true);
					director.setEditable(false);
					length.setEditable(false);
					cost.setEditable(true);
				}
				else if(index == 2) {
					title.setEditable(true);
					category.setEditable(true);
					director.setEditable(true);
					length.setEditable(false);
					cost.setEditable(true);
				}
				else if(index == 3) {

					title.setEditable(true);
					category.setEditable(true);
					director.setEditable(true);
					length.setEditable(true);
					cost.setEditable(true);
				}
				
			}
			
		});
		panel.add(new JLabel("Choose adding DVD options: "), 0);
		panel.add(addingOptionscb, 1);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addButton) {
					if(addingOptionscb.getSelectedIndex() == 0) {
						DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText());		
						store.addMedia(dvd);					
					}
					else if(addingOptionscb.getSelectedIndex() == 1) {
						DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), Float.parseFloat(cost.getText()));		
						store.addMedia(dvd);					
					}
					else if(addingOptionscb.getSelectedIndex() == 2) {
						DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Float.parseFloat(cost.getText()));		
						store.addMedia(dvd);					
					}
					else if(addingOptionscb.getSelectedIndex() == 3) {
						DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()));		
						store.addMedia(dvd);					
					}
					
					title.setText("");
					category.setText("");
					director.setText("");
					length.setText("");
					cost.setText("");
				}
			}
			
		});
		panel.add(addButton);

		Container cp = getContentPane();
		cp.add(panel, BorderLayout.CENTER);
		cp.add(createMenuBar(), BorderLayout.NORTH);
		setTitle("Add DVD");
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		smUpdateStore = new JMenu("Update Store");
		
		addBook = new JMenuItem("Add Book");
		addBook.addActionListener(this);
		smUpdateStore.add(addBook);
		
		addCD = new JMenuItem("Add CD");
		addCD.addActionListener(this);
		smUpdateStore.add(addCD);
		
		addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(this);
		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);
		
		viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(this);
		menu.add(viewStore);
		
		Logout = new JMenuItem("Logout");
		Logout.addActionListener(this);
		menu.add(Logout);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBook) {
			dispose();
			new AddBookToStoreScreen(store);
		}
		else if(e.getSource() == addDVD) {
			dispose();
			new AddDigitalVideoDiscToStoreScreen(store);
		}
		else if(e.getSource() == addCD) {
			dispose();
			new AddCompactDiscToStoreScreen(store);
		}
		else if(e.getSource() == viewStore) {
			dispose();
			new StoreManagerScreen(store);
		}
		else if(e.getSource() == Logout) {
			dispose();
			new LoginScreen(store);
		}
	}

}
