
public class Solution {
	//结果为排列组合C(m+n-2,m-1)
	//思路没问题，但是超时了
	public int uniquePaths(int m, int n) {
		//C(n-1, m-1)
		if (m<=n) {
			return cal(m+n-2, m-1);
		} else {
			return cal(m+n-2, n-1);
		}
	}
	
	public int cal(int m, int n) {
		if(n==0 || n==m) {
			return 1;
		}
		if(n == 1||n==m-1) {
			return m;
		}
		return cal(m-1, n) + cal(m-1, n-1);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.uniquePaths(51, 9));
	}
}
