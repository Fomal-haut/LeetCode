package second;

public class Solution {
	//一行代码解决，无需额外空间
	//从后往前，经典的逆向思维
	public void merge(int  A[], int m, int B[], int n) {
		while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
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
