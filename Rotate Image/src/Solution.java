public class Solution {
	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			rotateOnce(i, matrix);
		}
	}
	
	public void rotateOnce(int k, int[][] matrix) {
		int length = matrix.length - 2*k;
		int[] store = new int[length-1];
		for (int i = 0; i < length - 1; i++) {
			store[i] = matrix[k + i][length + k - 1];
		}
		
		//先顺时针转换3次
		for (int i=0; i< length - 1; i++) {
			matrix[k + i][length + k - 1] = matrix[k][k + i];
		}
		
		for (int i = 0; i < length - 1; i++) {
			matrix[k][k + i] = matrix[k + length - 1 - i][k];
		}
		
		for (int i = 0; i < length - 1; i++) {
			matrix[k + length - 1 - i][k] = matrix[k + length - 1][k + length - 1 - i];
		}
		
		for (int i = 0; i< length - 1; i++) {
			matrix[k + length - 1][k + length - 1 - i] = store[i];
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length;i++) {
			for (int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{3,3,2,1,8},{1,7,1,2,3},{3,9,1,4,5},{4,1,3,6,7},{3,1,5,4,6}};
		printMatrix(matrix);
		System.out.println();
		Solution solution = new Solution();
		solution.rotate(matrix);
		printMatrix(matrix);
	}
}
