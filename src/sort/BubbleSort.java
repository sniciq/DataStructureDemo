package sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {11,22,4,54,6,8,12,56,7};
		
		//两次for循环，故时间复杂度为O(n^2)
		//空间复杂度为O(n)
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
