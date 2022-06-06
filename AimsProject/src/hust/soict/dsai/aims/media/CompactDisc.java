package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		super();
	}
	
	public void addTrack(Track track) {
		boolean existStatus = false;
		
		for(Track t: this.tracks) {
			if(t.getTitle().equals(track.getTitle())) {
				existStatus = true;
				break;
			}
		}
		
		if(existStatus) {
			System.out.println("This track has been already in the cart.");
		}
		
		else {
			this.tracks.add(track);
			System.out.println("This track has been added.");
		}
	}
	
	public void removeTrack(Track track) {
		boolean existStatus = false;
		
		for(Track t: this.tracks) {
			if(t.getTitle().equals(track.getTitle())) {
				existStatus = true;
				break;
			}
		}
		
		if(!existStatus) {
			System.out.println("This track is not exist.");
		}
		
		else {
			this.tracks.remove(track);
			System.out.println("This track has been removed.");
		}
	}
	
	public int getLength() {
		int sumLength = 0;
		
		for(Track track: this.tracks) {
			sumLength+=track.getLength();
		}
		
		return sumLength;
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public void play() {
		System.out.println("Artist: " + this.getArtist());
		System.out.println("Total length: " + this.getLength());
		
		for(Track t: this.tracks) {
			t.play();
		}
	}

	public String toString() {
		String tracksString = "Track - " + this.tracks.get(0).getTitle() + " - " + this.tracks.get(0).getLength();
		
		for(int i = 1; i < this.tracks.size(); i++) {
			tracksString+="\n";
			tracksString+=("Track - " + this.tracks.get(i).getTitle() + " - " + this.tracks.get(i).getLength());
		}
		
		return "Compact disc - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$" + "\n" + tracksString;
	}
}
