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
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		addDigitalVideoDisc(disc1);
		addDigitalVideoDisc(disc2);
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int MaxNumSlotsLeft = MAX_NUMBERS_ORDERED - qtyOrdered;
		int prevQty = qtyOrdered;
		
		for(int i = 0; i < Math.min(MaxNumSlotsLeft, dvdList.length); i++) {
			addDigitalVideoDisc(dvdList[i]);
		}
		
		return qtyOrdered - prevQty;
	}
	
//*****************	
//	In this case, I prefer to use the method with a variable arguments because we can pass an array argument or just pass sequentially how many arguments you want to the method, then it seem to be more convenient
//*****************	

//	public int addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
//		int MaxNumSlotsLeft = MAX_NUMBERS_ORDERED - qtyOrdered;
//		int prevQty = qtyOrdered;
//		
//		for(int i = 0; i < Math.min(MaxNumSlotsLeft, dvdList.length); i++) {
//			addDigitalVideoDisc(dvdList[i]);
//		}
//		
//		return qtyOrdered - prevQty;
//	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int k = -1;
		if(qtyOrdered == 0) {
			System.out.println("The cart has already empty");
		}
		
		else {
			for(int i = 0; i < qtyOrdered; i++) {
				if(itemOrdered[i].getTitle() == disc.getTitle()) {
					k = i;
				}
			}
			if(k == -1) {
				System.out.println("This disc is not in cart");
			}
			else {
				for(int i = k; i < qtyOrdered - 1; i++) {
					itemOrdered[i] = itemOrdered[i+1];
				}
				itemOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("This disc has been removed");
				return 1;
			}
		}
		return 0;
	}
	
	public float totalCost() {
		float cost = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			cost+=itemOrdered[i].getCost();
		}
		
		return cost;		
	}
	
	
	
}
