public class Solution {
	public int[] plusOne(int[] digits) {
		int flag = 1;
		if (check(digits)) {
			int[] result = new int[digits.length+1];
			result[0] = 1;
			for (int j=0; j<digits.length; j++) {
				result[j+1] = 0;
			}
			return result;
		}
		for (int i=digits.length - 1; i>=0; i--) {
			if (digits[i] + flag == 10) {
				digits[i] = 0;
				flag = 1;
			} else {
				digits[i] = digits[i] + flag;
				flag = 0;
			}
		}
		return digits;
	}
	
	public boolean check(int[] digits) {
		boolean flag = true;
		for (int i=0; i< digits.length; i++) {
			if (digits[i] != 9) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		int[] a = {9};
		Solution solution = new Solution();
		int[] b = solution.plusOne(a);
		for (int j=0; j<b.length; j++) {
			System.out.println(b[j]);
		}
	}
}
