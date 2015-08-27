package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			
			mergePart(arr, left, mid, right);
		}
	}
	
	public static void mergePart(int[] arr, int left, int mid, int right) {
		int[] tt = Arrays.copyOfRange(arr, left, mid);
		System.out.print(Arrays.toString(tt) + "\t");
		int[] ttt = Arrays.copyOfRange(arr, mid, right);
		System.out.print(Arrays.toString(ttt) + "\t");
		System.out.println();
		
		
		int[] tempArr = Arrays.copyOf(arr, arr.length);
		int i = left;
		int j = mid + 1;
		int k = left;
		while(i <= mid && j <= right) {
			if(tempArr[i] <= tempArr[j]) {
				arr[k] = tempArr[i];
				i ++;
			}
			else {
				arr[k] = tempArr[j];
				j ++;
			}
			k ++;
		}
		
		while(i <= mid) {
			arr[k] = tempArr[i];
			k ++;
			i ++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {11,22,4,54,6,8,12,56,7};
		System.out.println(Arrays.toString(arr));
		MergeSort.sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
