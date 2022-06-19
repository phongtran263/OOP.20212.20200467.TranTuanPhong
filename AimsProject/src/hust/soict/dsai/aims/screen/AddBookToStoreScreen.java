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
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame implements ActionListener{
	private Store store;
	private JMenu smUpdateStore;
	private JMenuItem addBook;
	private JMenuItem addDVD;
	private JMenuItem addCD;
	private JMenuItem viewStore;
	private JMenuItem Logout;
	
	public AddBookToStoreScreen(Store store) {	
		this.store = store;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(6, 2, 1, 1));	
		
		JLabel lb1 = new JLabel("Enter title: ");
		panel.add(lb1);
		JTextField title = new JTextField();
		panel.add(title);
		
		JLabel lb2 = new JLabel("Enter authors: ");
		panel.add(lb2);
		JTextField authors = new JTextField();
		panel.add(authors);
		List<String> authorsList = Arrays.asList(authors.getText().split("\\P{L}+"));
		
		JLabel lb3 = new JLabel("Enter content: ");
		panel.add(lb3);
		JTextField content = new JTextField();
		panel.add(content);
		
		JLabel lb4 = new JLabel("Enter category: ");
		panel.add(lb4);
		JTextField category = new JTextField();
		panel.add(category);
		
		JLabel lb5 = new JLabel("Enter cost: ");
		panel.add(lb5);
		JTextField cost = new JTextField();
		panel.add(cost);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addButton) {
					Book book = new Book(title.getText(), authorsList, content.getText(), category.getText(), Float.parseFloat(cost.getText()));		
					store.addMedia(book);
					title.setText("");
					authors.setText("");
					content.setText("");
					category.setText("");
					cost.setText("");
				}
			}
			
		});
		panel.add(addButton);
		
		Container cp = getContentPane();
		cp.add(panel, BorderLayout.CENTER);
		cp.add(createMenuBar(), BorderLayout.NORTH);
		setTitle("Add Book");
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
