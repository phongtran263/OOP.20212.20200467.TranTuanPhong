
public class TestPassingParameter {

	public static void main(String[] args) {

		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderelDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderelDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderelDVD.getTitle());
		
		changeTitle(jungleDVD, cinderelDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
}
