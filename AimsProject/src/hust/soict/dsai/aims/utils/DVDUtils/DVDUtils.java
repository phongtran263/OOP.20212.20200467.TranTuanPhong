package hust.soict.dsai.aims.utils.DVDUtils;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class DVDUtils {

	public static boolean compareByCost(Media media1, Media media2) {		
		if(media1.getCost() >= media2.getCost()) {
			return true;
		}		
		
		return false;
	}
	
	public static boolean compareByTitle(Media media1, Media media2) {
		int l1 = media1.getTitle().length();
		int l2 = media2.getTitle().length();
		
		int lenMin = Math.min(l1, l2);
		for(int i = 0; i < lenMin; i++) {
			if((int)media1.getTitle().toLowerCase().charAt(i) > (int)media2.getTitle().toLowerCase().charAt(i)) {
				return true;
			}
			else if((int)media1.getTitle().toLowerCase().charAt(i) < (int)media2.getTitle().toLowerCase().charAt(i)) {
				return false;
			}
		}
		
		if(l1 >= l2) {
			return true;
		}

		return false;
	}
		
	public static ArrayList<Media> sortByCost(ArrayList<Media> mediaList) {
		QuickSortdvdList(mediaList, 0, mediaList.size() - 1, "cost", false);
		
		return mediaList;
	}
	
	public static ArrayList<Media> sortByTitle(ArrayList<Media> mediaList) {
		QuickSortdvdList(mediaList, 0, mediaList.size() - 1, "title", true);
		
		return mediaList;
	}
		
	private static void QuickSortdvdList(ArrayList<Media> mediaList, int start, int end, String type, boolean asc) {
		if(start < end) {
			int partition = PartitiondvdList(mediaList, start, end, type, asc);
			QuickSortdvdList(mediaList, start, partition - 1, type, asc);
			QuickSortdvdList(mediaList, partition + 1, end, type, asc);
		}
	}
	
	private static int PartitiondvdList(ArrayList<Media> mediaList, int start, int end, String type, boolean asc) {
		Media pivot = mediaList.get(end);
		int i = start - 1;

		for(int j = start; j < end; j++) {
			if(type.equals("cost")) {
				if(asc != compareByCost(mediaList.get(j), pivot)) {
					i++;
					Media tmp = mediaList.get(i);
					mediaList.set(i, mediaList.get(j));
					mediaList.set(j, tmp);
				}
			}
			else if(type.equals("title")) {
				if(asc != compareByTitle(mediaList.get(j), pivot)) {
					i++;
					Media tmp = mediaList.get(i);
					mediaList.set(i, mediaList.get(j));
					mediaList.set(j, tmp);
				}
			}
		}
		
		Media tmp = mediaList.get(i+1);
		mediaList.set(i+1, mediaList.get(end));
		mediaList.set(end, tmp);
		
		return i+1;
	}
	
}
