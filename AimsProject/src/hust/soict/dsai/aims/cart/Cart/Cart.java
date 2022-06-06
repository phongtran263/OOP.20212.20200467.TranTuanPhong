package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private boolean ChangeStatus = true;
	private Media luckyOne = new Media(false); // create null media
	
	public void addMedia(Media media) {
		if(this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		}
		
		else {
			boolean existStatus = false;
			
			for(Media m: this.itemsOrdered) {
				if(m.getTitle().equals(media.getTitle())) {
					existStatus = true;
					break;
				}
			}
			
			if(existStatus) {
				System.out.println("This media has been already in the cart.");
			}
			
			else {
				this.itemsOrdered.add(media);
				System.out.println("This media has been added.");
				this.ChangeStatus = true;
			}
		}
	}
	
	public void addMedia(Media media1, Media media2) {
		this.addMedia(media1);
		this.addMedia(media2);
	}
	
	public int addMedia(Media[] mediaList) {
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
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			if(this.itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
				System.out.println("This media has been removed.");
				this.ChangeStatus = true;
				return 1;
			}
		}
		
		System.out.println("This media is not exist.");
		return 0;
	}
	
	public int removeMedia(int index) {
		if((0 <= index) && (index< this.itemsOrdered.size())) {
			this.itemsOrdered.remove(index);
			System.out.println("The media at this index has been removed.");
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
		
		return cost;
	}
	
	public void CartSortByCost(boolean show) {
		this.itemsOrdered = DVDUtils.sortByCost(this.itemsOrdered);
		
		if(show) {
			System.out.println("sort by cost: ");
			for (int i = 0; i < this.itemsOrdered.size(); i++) {
				System.out.println(this.itemsOrdered.get(i).toString());
			}
		}
	}
	
	public void CartSortByTitle(boolean show) {
		this.itemsOrdered = DVDUtils.sortByTitle(this.itemsOrdered);

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
	
	public ArrayList<Media> SearchByTitle(String title) {
		ArrayList<Media> result = new ArrayList<Media>();
		
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
	
	public void print(boolean forOrder) {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsOrdered.get(i).toString());
		}
		this.luckyOne = this.getALuckyItem();
		if(this.luckyOne != null && forOrder && this.itemsOrdered.size() >= 5) {
			System.out.println("Congratulation!!! A lucky item is found in your cart. You can get it for free.");
			System.out.println(this.luckyOne.toString());
		}
		System.out.println("Total cost: " + this.totalCost(forOrder));
		System.out.println("***************************************************");
	}
	
	public void print(String type) {
		if(type == "title") {
			this.CartSortByCost(false);
			this.CartSortByTitle(false);
		}
		
		else if(type == "cost") {
			this.CartSortByTitle(false);
			this.CartSortByCost(false);
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.print((i+1) + ". ");
			System.out.println(this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost(false));
		System.out.println("***************************************************");
	}
	
	public void Empty() {
		for(int i = this.itemsOrdered.size() - 1; i >= 0; i--) {
			this.removeMedia(this.itemsOrdered.get(i));
		}
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
