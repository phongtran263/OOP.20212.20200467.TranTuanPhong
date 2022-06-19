package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame implements ActionListener{
	private Store store;
	private JMenu smUpdateStore;
	private JMenuItem addBook;
	private JMenuItem addDVD;
	private JMenuItem addCD;
	private JMenuItem viewStore;
	private JMenuItem Logout;
	private JButton back;
	private JButton next;
	private CardLayout cl = new CardLayout();
	private int showedPage;
	private JPanel centerPanel;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		
		centerPanel = createCenter();
		cl.show(centerPanel, "" + showedPage);
		cp.add(centerPanel);
		
		cp.add(createSwitchPage(), BorderLayout.SOUTH);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
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
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.blue);
		
		header.add(title);
		
		return header;
	}
	
	JPanel createSwitchPage() {
		JPanel swPg = new JPanel();
		swPg.setLayout(new GridLayout(1, 2, 1, 1));
		
		back = new JButton("<");
		back.addActionListener(this);
		swPg.add(back);
		
		next = new JButton(">");
		next.addActionListener(this);
		swPg.add(next);
		
		return swPg;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(cl);
		
		for(int page = 0; page <= store.getItemInStore().size()/9; page++) {
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(3, 3, 2, 2));
			
			ArrayList<Media> mediaInStore = store.getItemInStore();
			for(int j = page*9; j < (page + 1)*9; j++) {
				if(j < mediaInStore.size()) {
					MediaStore cell = new MediaStore(mediaInStore.get(j));
					p.add(cell);
				}
				else {
					p.add(new JPanel());
				}
			}
			center.add(p, "" + page);
		}
		
		return center;
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
		else if(e.getSource() == Logout) {
			dispose();
			new LoginScreen(store);
		}
		else if(e.getSource() == back) {
			showedPage = Math.max(0, showedPage - 1);
			cl.show(centerPanel, "" + showedPage);
		}
		else if(e.getSource() == next) {
			showedPage = Math.min(showedPage + 1, (int)(store.getItemInStore().size()/9));
			cl.show(centerPanel, "" + showedPage);
		}
	}
}
