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
			int b = 0;
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemOrdered[i].getTitle() == disc.getTitle()) {
					b = 1;
				}
			}
			
			if(b == 0) {
				itemOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The disc has already in the cart");
			}
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
