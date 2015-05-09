package second;

public class Solution {
	//比我的简洁多了，而且空间复杂度为O(1)
	//关键是找到四个交换元素的下标对应关系
	public void rotate(int[][] matrix) {
		int n = matrix[0].length - 1;
		for (int i = 0; i <= n - i; i++) {
			for (int j = i; j <= n - i - 1; j++) {
				int tmp = matrix[j][n - i];
				matrix[j][n - i] = matrix[i][j];
				matrix[i][j] = matrix[n - j][i];
				matrix[n - j][i] = matrix[n - i][n - j];
				matrix[n - i][n - j] = tmp;
			}
		}

	}
}
