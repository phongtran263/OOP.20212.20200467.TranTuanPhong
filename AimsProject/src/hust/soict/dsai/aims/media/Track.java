package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return this.title;
	}

	public int getLength() {
		return this.length;
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public String toString() {
		return "Track" + "\nTitle: " + this.getTitle() + "\nLength: " + this.getLength();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Track) {
			if((this.getTitle().equals(((Track) o).getTitle())) && (this.getLength() == ((Track) o).getLength())) {
				return true;
			}
		}
		
		return false;
	}
}
