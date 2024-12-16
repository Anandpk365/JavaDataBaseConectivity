package com.binarySerach;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { -19, -12, -9, -4, 0, 1, 2, 4, 7, 9, 34, 65, 87, 89 };
		int target = 545;
		int index = binarySearch(arr, target);

		if (index != -1)
			System.out.println("Index = " + index + ": " + arr[index]);
		else
			System.out.println("Target is not available in list.");
	}

	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
