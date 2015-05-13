
public class Solution {
	int[][] f;
	public int minPathSum(int [][] grid) {
		int x = grid.length;
		int y = grid[0].length;
		
		f = new int[x][y];
		f[0][0] = grid[0][0];
		
		for (int i = 1; i < x; i++) {
			f[i][0] = f[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < y; i++) {
			f[0][i] = f[0][i - 1] + grid[0][i];
		}
		
		for (int i =1 ; i<x;i++) {
			for (int j=1; j<y; j++) {
				f[i][j] = getMin(f[i-1][j], f[i][j-1]) + grid[i][j];
			}
		}
		return f[x-1][y-1];
	}
	
	private int getMin(int a, int b) {
		return a < b ? a : b;
	}
}
