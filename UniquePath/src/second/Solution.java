package second;

public class Solution {
	//动态规划：
	//f（m,n） = f(m-1,n) + f(m,n-1)
	public int uniquePaths(int m, int n) {
		int[][] result = new int[m+1][n+1];
		for (int i=1; i<=m; i++) {
			for (int j=1; j<=n; j++) {
				if (i==1 || j==1) {
					result[i][j] = 1;
				} else {
					result[i][j] = result[i-1][j] + result[i][j-1];
				}
			}
		}
		return result[m][n];
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.uniquePaths(3, 7));
	}
}
