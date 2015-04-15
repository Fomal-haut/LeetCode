package second;

public class Solution {
	//动态规划：
	//用一维数组解决，根据题目的特殊情况，一维数组可以重复使用，数据能够被覆盖
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] result = new int[width];
		result[0] = 1;
		
		for (int i = 0; i <  obstacleGrid.length; ++i) {
	        for (int j = 0; j < width; ++j) {
	            if (obstacleGrid[i][j] == 1)
	                result[j] = 0;
	            else if (j > 0)
	                result[j] += result[j-1];
	        }
	    }
	    return result[width-1];
	}
}
