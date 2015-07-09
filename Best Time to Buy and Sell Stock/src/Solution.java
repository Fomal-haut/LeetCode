public class Solution {
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length == 0) return 0;
		int profit = 0;
		int minVal = prices[0];
		int maxVal = minVal;
		for (int i=1; i<length; i++) {
			if (prices[i] > maxVal) {
				maxVal = prices[i];
				int curProfit = maxVal - minVal;
				if (curProfit > profit) {
					profit = curProfit;
				}
			} else if (prices[i] < minVal) {
				minVal = prices[i];
				maxVal = prices[i];
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
