public class Solution {
	public void rotate(int[] a, int k) {
//		k = k % nums.length;
//		if (k == 0) return;
//		int[] copyNum = new int[nums.length - k];
//		for (int i = 0; i < nums.length - k; i++) {
//			copyNum[i] = nums[i];
//		}
//		for (int j = nums.length - k; j < nums.length; j++) {
//			nums[j - nums.length + k] = nums[j];
//		}
//		for (int m = 0; m < copyNum.length; m++) {
//			nums[k + m] = copyNum[m];
//		}
	}
	
	public static void main(String[] args) {
		int[] number = {1,2,3,4,5,6,7};
		Solution solution = new Solution();
		solution.rotate(number, 2);
		for (int x : number) {
			System.out.println(x);
		}
	}
}
