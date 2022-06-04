package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_STORED = 999;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia() {
		
	}
	
	public void removeMedia() {
		
	}
	
	public Media SearchByTitle(String title) {
		int found = 0;
		Media result = null;

		for(int i = 0; i < itemsInStore.size(); i++) {
			Media media = itemsInStore.get(i);
			if(title.equals(media.getTitle())) {
				found = 1;
				result = media;
			}
		}
		
		if(found == 1) {
			System.out.println("Found media: " + result.toString());
			return result;
		}
		
		else if(found == 0) {
			System.out.println("Media is not found.");
		}
		
		return result;
	}
}
