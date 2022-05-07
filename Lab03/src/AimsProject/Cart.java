package AimsProject;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		}
		
		else {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int k = -1;
		if(qtyOrdered == 0) {
			System.out.println("The cart has already empty");
		}
		
		else {
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemOrdered[i] == disc) {
					k = i;
				}
			}
			if(k >= 0 && k < qtyOrdered - 1) {
				for(int i = k; i < qtyOrdered - 1; i++) {
					itemOrdered[i] = itemOrdered[i+1];
				}
			}
			if(k == -1) {
				System.out.println("This disc is not in cart");
			}
			else {
				itemOrdered[qtyOrdered - 1] = null;
				System.out.println("This disc has been removed");
			}
		}
		return k + 1;
		
	}
	
	public float totalCost() {
		float cost = 0;
		for(DigitalVideoDisc disc: itemOrdered) {
			if(disc != null) {
				cost+=disc.getCost();
			}
		}
		
		return cost;		
	}
	
	
	
}
