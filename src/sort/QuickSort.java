package sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] arr, int left, int right) {
		int pivot = arr[left + (right - left) /2 ];
		int i = left;
		int j = right;
		while (i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				
				i++;
				j--;
			}
		}
		
		if(left < j) {
			sort(arr, left, j);
		}
		
		if(i < right) {
			sort(arr, i, right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {11,22,4,54,6,8,12,56,7};
		QuickSort.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
