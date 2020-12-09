package lis;

//algorithm and implementation was referenced from GeeksforGeeks


class LIS {
	static int lenMaxSubseq;
	
	static int findMaxSubseq(int[] arr, int lenArr) {
		
		if(lenArr == 1) {
			return 1;
		}
		int result, endingMaxSeq = 1;
		for(int i = 1; i < lenArr; i++) {
			result = findMaxSubseq(arr, i);
			if(arr[i - 1] < arr[lenArr - 1] && result + 1 > endingMaxSeq) {
				endingMaxSeq = result + 1;
			}
		}
		
		if(lenMaxSubseq < endingMaxSeq) {
			lenMaxSubseq = endingMaxSeq;
		}
		
		return endingMaxSeq;
		
	}
	
	static int wrapperList(int[] arr, int lenArr) {
		lenMaxSubseq = 1;
		findMaxSubseq(arr, lenArr);
		return lenMaxSubseq;
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int n = arr.length; 
        System.out.println("Length of lis is "
                           + wrapperList(arr, n) + "\n"); 
	}
 } 