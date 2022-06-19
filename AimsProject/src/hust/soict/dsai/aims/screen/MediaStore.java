package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private static JDialog d = new JDialog(new JFrame(), "Play Media");;
	
	public MediaStore(Media media) {
		this.media = media;
		
		setLayout(new GridLayout(3, 1, 1, 1));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		cost.setHorizontalAlignment(JLabel.CENTER);
				
		this.add(title);
		this.add(cost);
		
		JPanel panel = new JPanel();
		if(media instanceof Playable) {
			String txt = "";
			if(media instanceof CompactDisc) {
				txt = "CD";
			}
			else if(media instanceof DigitalVideoDisc) {
				txt = "DVD";
			}
			JButton playButton = new JButton("Play " + txt);
			playButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == playButton) {
						JPanel p = new JPanel();
						p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
						JLabel l = new JLabel(((Playable) media).playStringForGUI());
						p.add(l);
						d.add(p);
						d.pack();
						d.setLocationRelativeTo(null);
						d.setVisible(true);
					}
				}
				
			});
			panel.add(playButton);
			add(panel);
		}
		else {
			add(new JPanel());
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}
}
