package com.ashish;

import java.util.Scanner;

public class QuickSort {

	
	private int numberOfElements;
	
	
	public void execute() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the size of the array you want");
		numberOfElements = reader.nextInt();
		int[] array = new int[numberOfElements];
		System.out.println("Enter values inside the Array");
		for(int i=0; i<numberOfElements; i++) {
			array[i] = reader.nextInt();
		}
		System.out.println("You entered following elements");
		printContents(array);
		System.out.println();
		
		sort(array);
		System.out.println("Contents after sorting:");
		printContents(array);
	}
	
	
	public void sort(int[] values){
		quickSort(values, 0, (values.length-1));
	}
	
	private void quickSort(int[] arr, int start, int end){
		if(start < end){
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
	
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		
		for(int i=start; i<end;i++) {
			if(arr[i] <= pivot) {
				int temp = arr[i];//swap logic
				arr[i]=arr[pIndex];
				arr[pIndex]= temp;
			
				pIndex++;
			}
		}
		int temp = arr[end]; //swap logic to swap pivot(arr[end]) with pIndex
		arr[end]=arr[pIndex];
		arr[pIndex]= temp;
		return pIndex;
	}// partition
	
	public void printContents(int[] arr) {
		for(int i=0; i<arr.length;i++)
			System.out.print(arr[i]+" --> ");
	}
}//end of class
