package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		boolean existStatus = false;
		
		for(Media m: this.itemsInStore) {
			if(m.getTitle().equals(media.getTitle())) {
				existStatus = true;
				break;
			}
		}
		
		if(existStatus) {
			System.out.println("This media has been already in the cart.");
		}
		
		else {
			this.itemsInStore.add(media);
			System.out.println("This media has been added.");
		}
	}
	
	public void addMedia(Media media1, Media media2) {
		this.addMedia(media1);
		this.addMedia(media2);
	}
	
	public void addMedia(Media[] mediaList) {		
		for(int i = 0; i < mediaList.length; i++) {
			this.addMedia(mediaList[i]);
		}
		
		System.out.println("All media have been added.");
	}
	
	public int removeMedia(Media media) {
		for(int i = 0; i < this.itemsInStore.size(); i++) {
			if(this.itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				System.out.println("This media has been removed.");
				return 1;
			}
		}
		
		System.out.println("This media is not exist.");
		return 0;
	}
	
	public int removeMedia(int index) {
		if((0 <= index) && (index< this.itemsInStore.size())) {
			this.itemsInStore.remove(index);
			System.out.println("The media at this index has been removed.");
			return 1;
		}
	
		System.out.println("The index is out of range!");
		return 0;
	}
	
	public Media SearchByTitle(String title) {

		for(int i = 0; i < this.itemsInStore.size(); i++) {
			Media media = this.itemsInStore.get(i);
			if(title.equals(media.getTitle())) {
				System.out.println("Found media: " + media.toString());
			}
		}
		
		System.out.println("Disc is not found.");		
		return null;
	}
}
