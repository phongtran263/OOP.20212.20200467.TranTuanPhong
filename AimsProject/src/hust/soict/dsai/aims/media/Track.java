package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.setTitle(title);
		this.setLength(length);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLength(int length) {
		this.length = length;
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
