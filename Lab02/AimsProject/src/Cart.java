
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered = 0;
	
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
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			System.out.println("The cart has already empty");
		}
		
		else {
			for(int i = 0, k = -1; i < qtyOrdered - 1; i++) {
				if(itemOrdered[i] == disc) {
					k = 0;
				}
				if(k >= 0) {
					itemOrdered[i] = itemOrdered[i+1];
				}
			}
			itemOrdered[qtyOrdered - 1] = null;
		}
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
