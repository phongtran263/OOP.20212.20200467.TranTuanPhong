package hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia() {
		
	}
	
	public void removeMedia() {
		
	}
		
	public float totalCost() {
		float cost = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			cost+=itemsOrdered.get(i).getCost();
		}
		
		return cost;		
	}
	
//	public void CartSortByCost(int show) {
//		DigitalVideoDisc[] result = new DigitalVideoDisc[itemsOrdered.size()];
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			result[i] = itemsOrdered.get(i);
//		}
//		result = DVDUtils.sortByCost(result);
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			itemsOrdered.get(i) = result[i];
//		}
//		if(show == 1) {
//			System.out.println("sort by cost: ");
//			for (int i = 0; i < result.length; i++) {
//				System.out.println(result[i].toString());
//			}
//		}
//	}
//	
//	public void CartSortByTitle(int show) {
//		DigitalVideoDisc[] result = new DigitalVideoDisc[itemsOrdered.size()];
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			result[i] = itemsOrdered.get(i);
//		}
//		result = DVDUtils.sortByTitle(result);
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			itemsOrdered.get(i) = result[i];
//		}
//		if(show == 1) {
//			System.out.println("sort by cost: ");
//			for (int i = 0; i < result.length; i++) {
//				System.out.println(result[i].toString());
//			}
//		}
//	}
//	
//	public void CartSortByLength(int show) {
//		DigitalVideoDisc[] result = new DigitalVideoDisc[itemsOrdered.size()];
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			result[i] = itemsOrdered.get(i);
//		}
//		result = DVDUtils.sortByLength(result);
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			itemsOrdered.get(i) = result[i];
//		}
//		if(show == 1) {
//			System.out.println("sort by cost: ");
//			for (int i = 0; i < result.length; i++) {
//				System.out.println(result[i].toString());
//			}
//		}
//	}
//	
//	public DigitalVideoDisc Search(int id) {
//		int found = 0;
//		DigitalVideoDisc result = null;
//		
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			DigitalVideoDisc dvd = itemsOrdered.get(i);
//			if(dvd.getId() == id) {
//				found = 1;
//				result = dvd;
//			}
//		}
//		
//		if(found == 1) {
//			System.out.println("Found disc: " + result.toString());
//			return result;
//		}
//		
//		else if(found == 0) {
//			System.out.println("Disc is not found.");
//		}
//		
//		return result;
//	}
//	
//	public DigitalVideoDisc[] SearchByTitle(String title) {
//		int found = 0;
//		DigitalVideoDisc[] result = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
//		int num = 0;
//		
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			DigitalVideoDisc dvd = itemsOrdered.get(i);
//			if(dvd.isMatch(title)) {
//				found = 1;
//				result[num] = dvd;
//				num++;
//			}
//		}
//		
//		if(found == 1) {
//			DigitalVideoDisc[] fresult = new DigitalVideoDisc[num];
//			for(int i = 0; i < num; i++) {
//				fresult[i] = result[i];
//				System.out.println("Found disc: " + fresult[i].toString());
//			}
//			return fresult;
//		}
//		
//		else if(found == 0) {
//			System.out.println("Disc is not found.");
//		}
//		
//		return null;
//	}
//	
//	public void print() {
//		this.CartSortByLength(0);
//		this.CartSortByCost(0);
//		this.CartSortByTitle(0);
//		System.out.println("***********************CART***********************");
//		System.out.println("Ordered Items:");
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			System.out.print((i+1) + ". ");
//			System.out.println(itemsOrdered.get(i).toString());
//		}
//		System.out.println("Total cost: " + this.totalCost());
//		System.out.println("***************************************************");
//	}
//	
//	public void print(String type) {
//		if(type == "title") {
//			this.CartSortByLength(0);
//			this.CartSortByCost(0);
//			this.CartSortByTitle(0);
//		}
//		
//		else if(type == "cost") {
//			this.CartSortByLength(0);
//			this.CartSortByTitle(0);
//			this.CartSortByCost(0);
//		}
//		System.out.println("***********************CART***********************");
//		System.out.println("Ordered Items:");
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			System.out.print((i+1) + ". ");
//			System.out.println(itemsOrdered.get(i).toString());
//		}
//		System.out.println("Total cost: " + this.totalCost());
//		System.out.println("***************************************************");
//	}
//	
//	public void Empty() {
//		for(int i = itemsOrdered.size() - 1; i >= 0; i--) {
//			this.removeDigitalVideoDisc(itemsOrdered.get(i));
//		}
//		System.out.println("The cart is empty now!");
//	}
	
}
