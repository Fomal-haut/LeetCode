public class Solution {
	public boolean canJump(int[] nums) {
		//贪心算法
		int maxLength=nums[0];
		
		for (int i=1 ; i< nums.length; i++){
			if (maxLength < i) {
				return false;
			}
			if ((nums[i] + i) > maxLength) {
				maxLength = nums[i] + i;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		Solution solution = new Solution();
		System.out.println(solution.canJump(nums));
	}
}
