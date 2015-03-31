package solution2;

public class Solution {
	public int majorityElement(int[] num) {
		char[] standard = new char[32];
		int count0, count1;
		for (int i = 0; i < 32; i++) {
			count0 = 0;
			count1 = 0;
			for (int j = 0; j < num.length; j++) {
				if (cal(num[j], i) == '1') {
					count1++;
				} else {
					count0++;
				}
			}
			if (count0 > count1) {
				standard[i] = '0';
			} else {
				standard[i] = '1';
			}
		}
		
		//根据standard的结果，打印最终的数据
		int result = 0;
		for (int i = 31; i >= 0; i --) {
			result = result << 1;
			if (standard[i] == '1') {
				result = result | 1;
			}
				
		}
		
		return result;
	}
	
	public static char cal(int num, int index) {
		num = num >> index;
		if ((num & 1) == 1) {
			return '1';
		} else {
			return '0';
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = new int[] {0,0,0,5,5,5,5,1,2,3,1,4,5,6,5,2,5,14,5,12,5,5,5,5,5,5,5};
		System.out.println(solution.majorityElement(a));
	}
}

