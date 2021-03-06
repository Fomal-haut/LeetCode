import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<> ();
		for (int i=0; i<=rowIndex; i++) {
			result.add(cal(rowIndex, i));
		}
		
		return result;
	}
	
	public int cal (int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		if (k > (n - k)) {
			k = n - k;
		}
		long result = 1;
		for (int i=1;i<=k;i++) {
			result *= (n + i - k);
	        result /= i;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> aa = solution.getRow(6);
		
		for (Integer it : aa) {
			System.out.println(it);
		}
	}
	
}
