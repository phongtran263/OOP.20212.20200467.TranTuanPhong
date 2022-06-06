package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track() {
		
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public String toString() {
		return "Track - " + this.getTitle() + " - " + this.getLength();
	}
}
