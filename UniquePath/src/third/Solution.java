package third;

public class Solution {
	//C(m+n-2,n-1)或者C(m+n-2,m-1)
	//参考一下别人优化的方法
	public int uniquePaths(int m, int n) {
		if( m == 1 || n ==1) return 1;
		   long count = 1;
		   //比较m和n的大小，可以减少循环次数，例如m大，就循环n次
		   //根据组合公式，可以看出(m+n-2)!/((m-1)!(n-1)!)除数可以连续除，防止数字溢出
		   //这里的count /= i 就是除了n－1次，即在循环里除了(n-1)!,把除的动作负载均衡
		   //而(m+n-2) - (m-1)正好为n－1，并且(m+n-2)!和(m-1)!能相约，多的是从m-1+1 *... m+n-2,一共正好n-1个数
		   if(m>n){
		       for(int i=1; i<=n-1; i++){
		           count *= (m + i - 1);
		           count /= i;
		       }
		   }else{
		       for(int i=1; i<=m-1; i++){
		           count *= (n + i - 1);
		           count /= i;
		       }
		   }
		   return (int)count;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.uniquePaths(3, 7));
	}
}
