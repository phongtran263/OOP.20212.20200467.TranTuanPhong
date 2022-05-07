package AimsProject;

public class Aims {

	public static void main(String[] args) {

		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);

		
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
//		System.out.println(anOrder.removeDigitalVideoDisc(dvd3));
		
		DigitalVideoDisc[] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		dvdList[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		dvdList[2] = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		anOrder.addDigitalVideoDisc(dvdList);
		
		System.out.print("The total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
