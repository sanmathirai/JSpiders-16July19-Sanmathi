package com.ustglobal.searchingalgo;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

class GFG  
{  
	public static int search(int arr[], int x) 
	{ 
		int n = arr.length; 
		for(int i = 0; i < n; i++) 
		{ 
			if(arr[i] == x) 
				return i; 
		} 
		return -1; 
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
		System.out.println("Enter element to be searched :");
		int x = sc.nextInt(); 
		Instant start = Instant.now();
		int result = search(arr, x); 
		if(result == -1) 
			System.out.print("Element is not present in array"); 
		else
			System.out.print("Element is present at index " + result);
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("Search time  "+seconds+" seconds");
	} 
} 
