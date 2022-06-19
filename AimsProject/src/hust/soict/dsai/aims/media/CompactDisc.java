package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, String artist, ArrayList<Track> tracks, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track track) {
		if(this.tracks.contains(track)) {
			System.out.println("This track has been already existed.");
		}

		else {
			this.tracks.add(track);
			System.out.println("This track has been added.");
		}
	}
	
	public ArrayList<Track> getTracks() {
		return this.tracks;
	}

	public void removeTrack(Track track) {		
		if(!this.tracks.contains(track)) {
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

	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.artist);
		System.out.println("Total length: " + this.getLength());
		
		for(Track t: this.tracks) {
			t.play();
		}
	}
	
	public String playStringForGUI() {
		String result = "<html>Playing CD: " + this.getTitle() + "<br>" + "Artist: " + this.artist + "<br>" + "Total length: " + this.getLength() + "<br>";
		for(Track t: this.tracks) {
			result+="<br>";
			String s = t.playStringForGUI();
			result+=s.substring(6, s.length() - 7);
		}
		result+="</html>";

		return result;
	}

	public String toString() {
		String tracksString = "";
		
		for(int i = 0; i < this.tracks.size(); i++) {
			tracksString+="\n";
			tracksString+= "-";
			tracksString+= this.tracks.get(i).toString();
		}
		
		return "CD" + "\nTitle: " + this.getTitle() + "\nCategory: " + this.getCategory() + "\nArtist: " + this.artist + "\nLength: " + this.getLength() + "\nCost: " + this.getCost() + "$\n" + tracksString + "\n";
	}
}
