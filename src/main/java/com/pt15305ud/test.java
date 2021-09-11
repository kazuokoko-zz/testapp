package com.pt15305ud;

public class test {

	public static void main(String[] args) {

		int[] nums = { 1, 6, 7, 3, 6, 5, 48, 3, 5, 3, 4 };

		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ",nums[i]);
		}
		System.out.println();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;

				}
			}

		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ",nums[i]);
		}

	}

}
