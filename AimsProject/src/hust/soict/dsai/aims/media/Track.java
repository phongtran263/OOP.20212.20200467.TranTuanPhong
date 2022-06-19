package hust.soict.dsai.aims.media;

public class Track implements Playable, Comparable<Track>{
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
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("track length: " + this.getLength());
	}

	public String toString() {
		return "Track" + "\nTitle: " + this.getTitle() + "\nLength: " + this.getLength() + "\n";
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

	@Override
	public int compareTo(Track o) {
		int l1 = this.getTitle().length();
		int l2 = o.getTitle().length();
		
		int lenMin = Math.min(l1, l2);
		for(int i = 0; i < lenMin; i++) {
			if((int)this.getTitle().toLowerCase().charAt(i) != (int)o.getTitle().toLowerCase().charAt(i)) {
				return (int)this.getTitle().toLowerCase().charAt(i) - (int)o.getTitle().toLowerCase().charAt(i);
			}
		}
		
		return l1 - l2;
	}

	@Override
	public String playStringForGUI() {
		return "<html>Playing track: " + this.getTitle() + "<br>" + "track length: " + this.getLength() + "<br></html>";
	}
}
