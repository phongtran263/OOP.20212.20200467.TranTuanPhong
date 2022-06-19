package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame implements ActionListener{
	private Store store;
	private JTextField title;
	private JTextField category;
	private JTextField artist;
	private JTextField cost;
	private JTextField titleTr;
	private JTextField lengthTr;
	private JMenu smUpdateStore;
	private JMenuItem addBook;
	private JMenuItem addDVD;
	private JMenuItem addCD;
	private JMenuItem viewStore;
	private JMenuItem Logout;
	
	public AddCompactDiscToStoreScreen(Store store) {	
		this.store = store;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(8, 2, 1, 1));	
		
		JLabel lb1 = new JLabel("Enter title: ");
		panel.add(lb1);
		title = new JTextField();
		panel.add(title);
		
		JLabel lb2 = new JLabel("Enter category: ");
		panel.add(lb2);
		category = new JTextField();
		panel.add(category);
		
		JLabel lb3 = new JLabel("Enter artist: ");
		panel.add(lb3);
		artist = new JTextField();
		panel.add(artist);
		
		JLabel lb4 = new JLabel("Enter cost: ");
		panel.add(lb4);
		cost = new JTextField();
		panel.add(cost);
		
		JLabel lb5 = new JLabel("Enter track info: ");
		panel.add(lb5);
		panel.add(new JLabel());
		
		JLabel lb6 = new JLabel("Enter track title: ");
		panel.add(lb6);
		titleTr = new JTextField();
		panel.add(titleTr);

		JLabel lb7 = new JLabel("Enter track length: ");
		panel.add(lb7);
		lengthTr = new JTextField();
		panel.add(lengthTr);
		
		addButtons(panel);
				
		Container cp = getContentPane();
		cp.add(panel, BorderLayout.CENTER);
		cp.add(createMenuBar(), BorderLayout.NORTH);
		setTitle("Add CD");
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	private void addButtons(JPanel panel) {
		CompactDisc cd = new CompactDisc("", "", "", new ArrayList<Track>(), 0);

		JButton addMoreTrackButton = new JButton("Add more track");
		addMoreTrackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addMoreTrackButton) {
					cd.addTrack(new Track(titleTr.getText(), Integer.parseInt(lengthTr.getText())));
					titleTr.setText("");
					lengthTr.setText("");
				}
			}
			
		});
		panel.add(addMoreTrackButton);		
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addButton) {
					cd.setTitle(title.getText());
					cd.setCategory(category.getText());
					cd.setArtist(artist.getText());
					cd.setCost(Float.parseFloat(cost.getText()));
					store.addMedia(cd);					
					title.setText("");
					artist.setText("");
					category.setText("");
					cost.setText("");
				}
			}
			
		});
		panel.add(addButton);
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
