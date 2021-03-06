public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int[] pre = new int[prices.length];
		int[] post = new int[prices.length];
		
		int profit = 0;
		pre[0] = 0;
		int minVal = prices[0];
		int maxVal = minVal;
		for (int i = 1; i < prices.length; i++) {
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
			pre[i] = profit;
		}
		
		profit = 0;
		post[prices.length - 1] = 0;
		maxVal = prices[prices.length - 1];
		minVal = maxVal;
		
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] < minVal) {
				minVal = prices[i];
				int curProfit = maxVal - minVal;
				if (curProfit > profit) {
					profit = curProfit;
				}
			} else if (prices[i] > maxVal) {
				maxVal = prices[i];
				minVal = prices[i];
			}
			post[i] = profit;
		}
		
		int maxSum = -1;
		for (int j = 0; j < prices.length; j++) {
			int curSum = post[j] + pre[j];
			if (curSum > maxSum) 
				maxSum = curSum;
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {2,1};
		System.out.println(solution.maxProfit(prices));
 	}
}
