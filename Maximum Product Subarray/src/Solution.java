public class Solution {
	//同最大连续和相比，这里是乘，多了一个弯
	//其实也不复杂，纪录连续的最小值，因为负值可能在乘以1个负值之后就变成最大值了
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		
		int maxNum = nums[0];
		int minNum = nums[0];
		
		int result = maxNum;
		
		for (int i=1; i<nums.length; i++) {
			int maxCopy = maxNum;
			maxNum = Math.max(Math.max(maxNum * nums[i], nums[i]), minNum * nums[i]);
			minNum = Math.min(Math.min(minNum * nums[i], nums[i]), maxCopy * nums[i]);
			result = Math.max(maxNum, result);
		}
		return result;
	}
}
