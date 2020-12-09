package lis;

//algorithm and implementation was referenced from GeeksforGeeks, contributed by Rajat Mishra

import java.util.Random;

class LIS {
	static int lenMaxSubseq;

	static int findMaxSubseq(int[] arr, int lenArr) {

		// base case
		if (lenArr == 1) {

			return 1;
		}

		int result, recursLenSubseq = 1;

		// recursively calculates the LIS from the beginning of the array to each index
		for (int i = 1; i < lenArr; i++) {

			result = findMaxSubseq(arr, i);
			if (arr[i - 1] < arr[lenArr - 1] && result + 1 > recursLenSubseq) {
				recursLenSubseq = result + 1;
			}
		}
		
		//compare current recurse LIS with the current recorded largest LIS
		if (lenMaxSubseq < recursLenSubseq) {

			lenMaxSubseq = recursLenSubseq;
		}

		return recursLenSubseq;

	}

	static int wrapperFindMaxSubseq(int[] arr, int lenArr) {
		lenMaxSubseq = 1;
		findMaxSubseq(arr, lenArr);
		return lenMaxSubseq;
	}

	// main call, populates int array of size 10 with randomly generated ints
	public static void main(String[] args) {
		Random rd = new Random();
		int[] arr = new int[10];
		System.out.println("Longest Increasing Subsequence" + "\n");
		System.out.println("Random Array of Ints");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(10000);
			System.out.println((i + 1) + ": " + arr[i]);
		}
		int n = arr.length;
		System.out.println("\n" + "Length of LIS is " + wrapperFindMaxSubseq(arr, n));
	}
}