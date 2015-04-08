package second;

public class Solution {
	public int removeDuplicates (int[] A) {
		if (A.length == 0) {
			return 0;
		}
		
		int length = 0;
		int pos;
		int counter = 0;
		for (pos = 1; pos < A.length; pos++) {
			if (A[pos] != A[length]) {
				counter = 0;
				length ++;
				A[length] = A[pos];
			} else {
				if (counter < 1) {
					counter++;
					length++;
					A[length] = A[pos];
				}
			}
		}
		return length + 1;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,3,3,4,4,4,5,5,5,5,6,6,7,8,8,8,9,9,9,9,9,10,10,10};
		Solution solution = new Solution();
		int result = solution.removeDuplicates(A);
		System.out.println(result);
		for (int i=0; i<result; i++) {
			System.out.println(A[i]);
		}
	}
}
