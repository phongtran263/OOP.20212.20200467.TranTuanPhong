import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WorkingWithArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double sum = 0, average;
		
		ArrayList<Number> array = new ArrayList<Number>();
		array.addAll(new ArrayList<Number>(Arrays.asList(123,323,3453,12,34,231,1.6434,787,32,23.34,56.678,8,43,1.123132,456,876)));

		
		MergeSort(array);
		
		for(Number i: array) {
			sum+=i.doubleValue();
		}

		average = sum/array.size();
		
		System.out.println("Sorted array: " + array);
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);
	}
	
	public static void MergeSort(ArrayList<Number> array) {
		
		if(array.size() == 2) {
			Number min = Math.min(array.get(0).doubleValue(), array.get(1).doubleValue());
			Number max = Math.max(array.get(0).doubleValue(), array.get(1).doubleValue());
			array.set(0, min);
			array.set(1, max);
		}
		
		else if(array.size() > 2) {
			int pivot = array.size()/2;
			ArrayList<Number> array1 = new ArrayList<Number>(array.subList(0, pivot));
			ArrayList<Number> array2 = new ArrayList<Number>(array.subList(pivot, array.size()));
			
			MergeSort(array1);
			MergeSort(array2);
			ArrayList<Number> arrayT = Merge(array1, array2);
			for(int i = 0; i < arrayT.size(); i++) {
				array.set(i, arrayT.get(i));
			}
			
		}
	}
	
	public static ArrayList<Number> Merge(ArrayList<Number> array1, ArrayList<Number> array2) {
		
		ArrayList<Number> array = new ArrayList<Number>();
		int sumSize = array1.size() + array2.size();
		
		array1.add(Double.POSITIVE_INFINITY);
		array2.add(Double.POSITIVE_INFINITY);
		for(int i = 0; i < sumSize; i++) {
			if(array1.get(0).doubleValue() < array2.get(0).doubleValue()) {
				array.add(array1.get(0));
				array1.remove(0);
			}
			else {
				array.add(array2.get(0));
				array2.remove(0);
			}
		}
		return array;	
	}

}
