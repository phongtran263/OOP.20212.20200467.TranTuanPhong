package hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 999;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDVD(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The store is almost full");
		}
		
		else {
			int b = 0;
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemsInStore[i].getTitle() == disc.getTitle()) {
					b = 1;
				}
			}
			
			if(b == 0) {
				itemsInStore[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The disc has already in the store");
			}
		}
	}
	
	public void addDVD(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		addDVD(disc1);
		addDVD(disc2);
	}
	
	public int addDVD(DigitalVideoDisc[] dvdList) {
		int MaxNumSlotsLeft = MAX_NUMBERS_ORDERED - qtyOrdered;
		int prevQty = qtyOrdered;
		
		for(int i = 0; i < Math.min(MaxNumSlotsLeft, dvdList.length); i++) {
			addDVD(dvdList[i]);
		}
		
		return qtyOrdered - prevQty;
	}
	
	public int removeDVD(DigitalVideoDisc disc) {
		int k = -1;
		if(qtyOrdered == 0) {
			System.out.println("The store has already empty");
		}
		
		else {
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemsInStore[i].getTitle() == disc.getTitle()) {
					k = i;
				}
			}
			if(k == -1) {
				System.out.println("This disc is not in store");
			}
			else {
				for(int i = k; i < qtyOrdered - 1; i++) {
					itemsInStore[i] = itemsInStore[i+1];
				}
				itemsInStore[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("This disc has been removed");
				return 1;
			}
		}
		return 0;
	}
	
	public DigitalVideoDisc SearchByTitle(String title) {
		int found = 0;
		DigitalVideoDisc result = null;

		for(int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc dvd = itemsInStore[i];
			if(dvd.isMatch(title)) {
				found = 1;
				result = dvd;
			}
		}
		
		if(found == 1) {
			System.out.println("Found disc: " + result.toString());
		}
		
		else if(found == 0) {
			System.out.println("Disc is not found.");
		}
		
		return result;
	}
}
