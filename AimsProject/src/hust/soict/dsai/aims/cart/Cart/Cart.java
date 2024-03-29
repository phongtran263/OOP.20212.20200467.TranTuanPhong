package hust.soict.dsai.aims.cart.Cart;
import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.ExistException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private boolean ChangeStatus = true;
	private Media luckyOne = null;
	
	public void addMedia(Media media) throws LimitExceededException, ExistException {
		if(this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
			throw new LimitExceededException("ERROR: The number of medias has reached its limit");
		}
		
		else {
			if(itemsOrdered.contains(media)) {
				System.out.println("This media has been already in the cart.");
				throw new ExistException("ERROR: This media has been already in the cart");
			} 

			else {
				this.itemsOrdered.add(media);
				System.out.println("This media has been added.");
				this.ChangeStatus = true;
			}
		}
	}
	
	public void addMedia(Media media1, Media media2) throws LimitExceededException, ExistException {
		this.addMedia(media1);
		this.addMedia(media2);
	}
	
	public int addMedia(Media[] mediaList) throws LimitExceededException, ExistException {
		int maxNumMediaAdd = Math.min(MAX_NUMBERS_ORDERED - this.itemsOrdered.size(), mediaList.length);
		
		for(int i = 0; i < maxNumMediaAdd; i++) {
			this.addMedia(mediaList[i]);
		}
		
		if(this.itemsOrdered.size() <= MAX_NUMBERS_ORDERED) {
			System.out.println("All media have been added.");
		}
		
		else {
			System.out.println("The system can add at most " + maxNumMediaAdd + " media(s).");
		}
		
		return maxNumMediaAdd;
	}
	
	public int removeMedia(Media media) {
		if(this.itemsOrdered.contains(media)) {
			this.itemsOrdered.remove(media);
			System.out.println("This media has bee removed.");
			this.ChangeStatus = true;
		 	return 1;
		}
		
		System.out.println("This media is not exist.");
		return 0;
	}
	
	public int removeMedia(int index) {
		if((0 <= index) && (index< this.itemsOrdered.size())) {
			this.itemsOrdered.remove(index);
			System.out.println("The media has been removed.");
			this.ChangeStatus = true;
			return 1;
		}
	
		System.out.println("The index is out of range!");
		return 0;
	}
	
	public float totalCost(boolean forOrder) {
		float cost = 0;
		for(Media media: this.itemsOrdered) {
			cost+=media.getCost();
		}
		
		if(this.itemsOrdered.size() >= 5 && forOrder) {
			cost-=this.getALuckyItem().getCost();
		}
		
		return (float)Math.round(cost*100)/100;
	}
	
	public void CartSortByCostTitle(boolean show, boolean increase) {
		if(increase) {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_INCREASE_COST_TITLE);
		}
		else {
			Collections.sort(this.itemsOrdered, Media.COMPARE_BY_DECREASE_COST_TITLE);
		}
		
		if(show) {
			System.out.println("sort by cost: ");
			for (int i = 0; i < this.itemsOrdered.size(); i++) {
				System.out.println(this.itemsOrdered.get(i).toString());
			}
		}
	}
	
	public void CartSortByTitleCost(boolean show, boolean increase) {
		if(increase) {
			Collections.sort(this.itemsOrdered, Media.COMPARE_BY_INCREASE_TITLE_COST);
		}
		else {
			Collections.sort(this.itemsOrdered, Media.COMPARE_BY_DECREASE_TITLE_COST);
		}
		
		if(show) {
			System.out.println("sort by title: ");
			for (int i = 0; i < this.itemsOrdered.size(); i++) {
				System.out.println(this.itemsOrdered.get(i).toString());
			}
		}
	}
		
	public Media Search(int id) {
		
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			if(this.itemsOrdered.get(i).getId() == id) {
				System.out.println("Found media: " + this.itemsOrdered.get(i).toString());
				return this.itemsOrdered.get(i);
			}
		}
				
		System.out.println("Media is not found.");		
		return null;
	}
	
	public ObservableList<Media> SearchByTitle(String title) {
		ObservableList<Media> result = FXCollections.observableArrayList();
		
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			if(this.itemsOrdered.get(i).isMatch(title)) {
				result.add(this.itemsOrdered.get(i));
			}
		}
		
		if(result.size() > 0) {
			for(int i = 0; i < result.size(); i++) {
				System.out.println("Found disc: " + result.get(i).toString());
			}
			return result;
		}
		
		System.out.println("Media is not found.");		
		return result;
	}
	
	public Media getMediaAtIndex(int index) {
		return this.itemsOrdered.get(index);
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Items:");
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost(false) + "$");
		System.out.println("***************************************************");
	}
	
	public void printFor(String purpose) {
		if(purpose == "Order") {
			System.out.println("***********************CART***********************");
			System.out.println("Items:");
			for(int i = 0; i < this.itemsOrdered.size(); i++) {
				System.out.print((i+1) + ". ");
				System.out.println(this.itemsOrdered.get(i).toString());
			}
			this.luckyOne = this.getALuckyItem();
			if(this.luckyOne != null && this.itemsOrdered.size() >= 5) {
				System.out.println("---------------------------------");
				System.out.println("Congratulation!!! A lucky item is found in your cart. You can get it for free.");
				System.out.println(this.luckyOne.toString());
				System.out.println("---------------------------------");
			}
			System.out.println("Total cost: " + this.totalCost(true) + "$");
			System.out.println("***************************************************");
		}
		
		else if(purpose == "Play") {
			System.out.println("***********************CART***********************");
			System.out.println("Items:");
			for(int i = 0; i < this.itemsOrdered.size(); i++) {
				String playable = "";
				if(this.itemsOrdered.get(i) instanceof Playable) {
					playable = "\n**Play**\n";
				}
				System.out.print((i+1) + ". ");
				System.out.println(this.itemsOrdered.get(i).toString() + playable);
			}
			System.out.println("***************************************************");			
		}
	}
	
	public void Sortprint(String type) {
		if(type == "title") {
			this.CartSortByTitleCost(false, true);
		}
		
		else if(type == "cost") {
			this.CartSortByCostTitle(false, false);
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost(false) + "$");
		System.out.println("***************************************************");
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void Empty() {
		this.itemsOrdered = FXCollections.observableArrayList();
		System.out.println("The cart is empty now!");
	}
	
	public Media getALuckyItem() {
		if(this.itemsOrdered.size() >= 5 && this.ChangeStatus) {
			int luckyIndex = (int)(Math.random()*this.itemsOrdered.size());
			this.ChangeStatus = false;
			this.luckyOne = this.itemsOrdered.get(luckyIndex);
			return this.luckyOne;
		}
		
		return this.luckyOne;
	}
	
}