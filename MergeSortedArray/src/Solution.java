
public class Solution {
	public void merge(int  A[], int m, int B[], int n) {
		if (m == 0) {
			copyArray(B, 0, n, A, 0);
			return;
		}
		if (n == 0) {
			return;
		}
		int[] temp = new int[m + n];
		int x = 0;
		int y = 0;
		for (int i = 0; i < m + n; i++) {
			if (A[x] <= B[y]) {
				temp[i] = A[x];
				x++;
				if (x == m) {
					copyArray(B, y, n, temp, i+1);
					break;
				}
			} else {
				temp[i] = B[y];
				y++;
				if (y == n) {
					copyArray(A, x, m, temp, i+1);
					break;
				}
			}
		}
		
		copyArray(temp, 0, m+n,  A, 0);
	}
	
	public void copyArray(int[] src, int srcOffSet, int srcLength, int[] dst, int dstOffSet) {
		for (int i=0; i<srcLength - srcOffSet; i++) {
			dst[dstOffSet + i] = src[srcOffSet + i];
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[5];
//		A[0] = 2;
//		A[1] = 3;
//		A[2] = 5;
//		A[3] = 6;
//		A[4] = 8;
//		A[5] = 9;
//		A[6] = 21;
//		A[7] = 23;
//		A[8] = 24;
//		A[9] = 25;
		
		int[] B = {1,4,7,8};
		
		Solution solution = new Solution();
		solution.merge(A, 0, B, 4);
		for (int i=0; i<4; i++) {
			System.out.println(A[i]);
		}
		
	}
}
