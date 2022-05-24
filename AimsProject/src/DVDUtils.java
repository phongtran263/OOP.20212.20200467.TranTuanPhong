
public class DVDUtils {

	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int result = 0;
		
		if(dvd1.getCost() > dvd2.getCost()) {
			result = 1;
		}		
		else if(dvd1.getCost() < dvd2.getCost()) {
			result = -1;
			
		}		
		else {
			result = 0;
		}
		
		return result;
	}
	
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int result = 0;
		int l1 = dvd1.getTitle().length();
		int l2 = dvd2.getTitle().length();
		
		int lenMin = Math.min(l1, l2);
		for(int i = 0; i < lenMin; i++) {
			if(dvd1.getTitle().charAt(i) != dvd2.getTitle().charAt(i)) {
				result = (int)dvd1.getTitle().charAt(i) - (int)dvd2.getTitle().charAt(i);
				result = result/(Math.abs(result));
				return result;
			}
		}
		
		if(l1 > l2) {
			result = 1;
			return result;
		}

		if(l1 < l2) {
			result = -1;
			return result;
		}

		return result;
	}
	
	public static int compareByLength(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int result = 0;
		int l1 = dvd1.getLength();
		int l2 = dvd2.getLength();
		
		if(l1 > l2) {
			result = 1;
		}
		else if(l1 < l2) {
			result = -1;
		}
		return result;
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		DigitalVideoDisc[] result = dvdList.clone();

		QuickSortdvdList(result, 0, result.length - 1, "cost", -1);
		
		return result;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
		DigitalVideoDisc[] result = dvdList.clone();

		QuickSortdvdList(result, 0, result.length - 1, "title", 1);
		
		return result;
	}
	
	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc[] dvdList) {
		DigitalVideoDisc[] result = dvdList.clone();
		
		QuickSortdvdList(result, 0, result.length - 1, "length", -1);

		return result;
	}
	
	private static void QuickSortdvdList(DigitalVideoDisc[] dvdList, int start, int end, String type, int asc) {
		if(start < end) {
			int partition = PartitiondvdList(dvdList, start, end, type, asc);
			QuickSortdvdList(dvdList, start, partition - 1, type, asc);
			QuickSortdvdList(dvdList, partition + 1, end, type, asc);
		}
	}
	
	private static int PartitiondvdList(DigitalVideoDisc[] dvdList, int start, int end, String type, int asc) {
		DigitalVideoDisc pivot = dvdList[end];
		int i = start - 1;

		for(int j = start; j < end; j++) {
			if(type == "cost") {
				if(asc*compareByCost(dvdList[j], pivot) <= 0) {
					i++;
					DigitalVideoDisc tmp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = tmp;
				}
			}
			else if(type == "title") {
				if(asc*compareByTitle(dvdList[j], pivot) <= 0) {
					i++;
					DigitalVideoDisc tmp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = tmp;
				}
			}
			else if(type == "length") {
				if(asc*compareByLength(dvdList[j], pivot) <= 0) {
					i++;
					DigitalVideoDisc tmp = dvdList[i];
					dvdList[i] = dvdList[j];
					dvdList[j] = tmp;
				}

			}
		}
		
		DigitalVideoDisc tmp = dvdList[i+1];
		dvdList[i+1] = dvdList[end];
		dvdList[end] = tmp;
		
		return i+1;
	}
	
}
