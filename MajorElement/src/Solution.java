
public class Solution {
	public int majorityElement(int[] num) {
		int count = 1;
		int result = num[0];
		
		for (int i = 1; i < num.length; i++) {
			if (result == num[i]) {
				count ++;
			} else {
				count --;
				if (count == -1) {
					result = num[i];
					count = 1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = new int[] {0,0,1};
		System.out.println(solution.majorityElement(a));
	}
}
