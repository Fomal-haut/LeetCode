public class Solution {
	//最为基础的二分查找法
	public int[] searchRange(int[] nums, int target) {
		int[] result = {nums.length, -1};
		binarySearch(0, nums.length-1, target, nums, result);
		if (result[0] > result[1]) result[0] = -1;
		return result;
	}
	
	public void binarySearch(int firstIndex, int lastIndex, int target, int[] nums, int[] result) {
		if (firstIndex > lastIndex) return;
		int mid = firstIndex + (lastIndex - firstIndex) /2;
		if (nums[mid] == target) {
			if (mid < result[0]) {
				result[0] = mid;
				binarySearch(firstIndex, mid-1, target, nums, result);
			}
			if (mid > result[1]) {
				result[1] = mid;
				binarySearch(mid+1, lastIndex, target, nums, result);
			}
		} else if (nums[mid] <target) {
			binarySearch(mid+1, lastIndex, target, nums, result);
		} else {
			binarySearch(firstIndex, mid-1, target, nums, result);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		Solution solution = new Solution();
		int[] result = solution.searchRange(nums, 8);
		for (int i : result) {
			System.out.println(i);
		}
		
	}
}
