package main;

import algoritmos.CountingSort;
import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import algoritmos.QuickSort;
import algoritmos.RadixSort;
import algoritmos.SelectionSort;

public class Main{
	
	public static void main(String[] args){
		
		CountingSort cs = new CountingSort("couting.txt");
		CountingSort cs2 = new CountingSort("num.1000.1.in");
		RadixSort rs = new RadixSort("num.1000.1.in");
		InsertionSort is = new InsertionSort("num.1000.1.in");
		SelectionSort ss = new SelectionSort("num.1000.1.in");
		MergeSort ms = new MergeSort("num.1000.1.in");
		QuickSort qs = new QuickSort("num.1000.1.in");
		
		long[] A = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17}, B = null;		
		long[] C = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		
		B = CountingSort.algoritmoCountingSort(A);
		InsertionSort.algoritmoInsertionSort(A);
		RadixSort.algoritmoRadixSort(C);
				
		long D[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};		
		SelectionSort.algoritmoSelectionSort(D);
		
		long E[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		MergeSort.algoritmoMergeSort(E, 0, E.length - 1);
		
		long F[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		QuickSort.algoritmoQuickSort2(F, 0, F.length - 1);
		
		CountingSort cs3 = new CountingSort("num.10000.4.in");
		RadixSort rs2 = new RadixSort("num.100000.4.in");
		InsertionSort is2 = new InsertionSort("num.100000.4.in");
		SelectionSort ss2 = new SelectionSort("num.100000.4.in");
		MergeSort ms2 = new MergeSort("num.100000.4.in");
		QuickSort qs2 = new QuickSort("num.100000.4.in");
				
		System.out.println("Finish!");

	}

}
