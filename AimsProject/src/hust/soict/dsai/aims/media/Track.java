package hust.soict.dsai.aims.media;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
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
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Track) {
			return (this.getTitle() == ((Track) o).getTitle()) && (this.getLength() == ((Track) o).getLength());
		}
		
		return false;
	}

	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
