public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int hsize = obstacleGrid.length;
		int psize = obstacleGrid[0].length;
		
		int[][] result = new int[hsize+1][psize+1];
		for (int i = 0; i <= hsize; i++) {
			for (int j = 0; j <= psize; j++) {
				if (i == 0 || j == 0) {
					result[i][j] = 0;
				} else if (i==1 && j==1){
					if (obstacleGrid[0][0] == 1) {
						return 0;
					} else {
						result[i][j] = 1;
					}
				} else if (obstacleGrid[i - 1][j - 1] == 1) {
					result[i][j] = 0;
				} else {
					result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}
		return result[hsize][psize];
	}
	
	public static void main(String[] args) {
		int[][] tt = {{0,0,0},{0,1,0},{0,0,0}};
		Solution solution = new Solution();
		System.out.println(solution.uniquePathsWithObstacles(tt));
	}
}
