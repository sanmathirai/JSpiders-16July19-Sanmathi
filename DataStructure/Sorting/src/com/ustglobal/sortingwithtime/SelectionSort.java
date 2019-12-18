package com.ustglobal.sortingwithtime;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class SelectionSort {
	void sort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
 
    // Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver code to test above
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int[] arr =  new int[size];
		System.out.println("Enter Array elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] =  sc.nextInt(); 
		}
		 Instant start = Instant.now();
        ob.sort(arr);
        Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("Bubble sort time  "+seconds+" seconds");
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
