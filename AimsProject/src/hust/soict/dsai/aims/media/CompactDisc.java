package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
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

}
