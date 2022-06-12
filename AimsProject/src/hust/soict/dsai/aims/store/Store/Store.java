package hust.soict.dsai.aims.store.Store;
import java.text.DecimalFormat;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("This media has been already in the store.");
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
				return media;
			}
		}
		
		System.out.println("Disc is not found.");		
		return new Media(false);
	}
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items:");
		for(int i = 0; i < this.itemsInStore.size(); i++) {
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
	}
	
	public void printForPlay() {
		System.out.println("***********************CART***********************");
		System.out.println("Items:");
		for(int i = 0; i < this.itemsInStore.size(); i++) {
			String playable = "";
			if(this.itemsInStore.get(i) instanceof Playable) {
				playable = "\nPlay";
			}
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsInStore.get(i).toString() + playable);
		}
		System.out.println("***************************************************");			
	}
	
	public Media getMediaAtIndex(int index) {
		return this.itemsInStore.get(index);
	}
}