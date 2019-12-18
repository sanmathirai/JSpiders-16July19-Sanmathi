package com.ustglobal.sortingwithtime;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

class QuickSort 
{ 

	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high];  
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 

			if (arr[j] <= pivot) 
			{ 
				i++; 


				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 


		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 



	void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 

			int pi = partition(arr, low, high); 


			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 


	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 


	public static void main(String args[]) 
	{ 

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int[] arr =  new int[size];
		System.out.println("Enter Array elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] =  sc.nextInt(); 
		}
		int n = arr.length; 
		Instant start = Instant.now();
		QuickSort ob = new QuickSort(); 

		ob.sort(arr, 0, n-1); 
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("Quick sort time  "+seconds+" seconds");

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
} 
