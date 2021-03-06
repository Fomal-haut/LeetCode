public class Solution {
	public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (nums[start] >= target) {
			return start;
		} else {
			return start + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		Solution solution = new Solution();
		System.out.println(solution.searchInsert(nums, 0));
	}
}
