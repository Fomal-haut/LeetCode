
public class Solution {
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length == 0) return 0;
		int profit = 0;
		int minVal = prices[0];
		
		for (int i = 1; i < length; i++) {
			if (prices[i] > minVal) {
				profit += prices[i] - minVal;
				minVal = prices[i];
			} else {
				minVal = prices[i];
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {2,1,4};
		System.out.println(solution.maxProfit(prices));
 	}
}
