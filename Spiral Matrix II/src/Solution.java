public class Solution {
	// 注意观察下标和层数的数学关系即可
	// 每一层的边长和元素坐标都可以推算出通项式
	public int[][] generateMatrix(int n) {
		int [][] matrix = new int[n][n];
		int steps = 1;
		int k;
		for (int i = n; i > 0; i = i - 2) {
			int length = i-1;
			int index = (n - i)/2;
			if (length == 0) {
				matrix[index][index]=steps;
				break;
			}
			
			for (k = index; k < length + index; k++) {
				matrix[index][k] = steps;
				steps++;
			}
			
			for (k = index; k < length + index; k++) {
				matrix[k][index + length] = steps;
				steps++;
			}
			
			for (k = length + index; k > index; k--) {
				matrix[index + length][k] = steps;
				steps++;
			}

			for (k = length + index; k > index; k--) {
				matrix[k][index] = steps;
				steps++;
			}
			
		}
		
		
		return matrix;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] result = solution.generateMatrix(5);
		
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
