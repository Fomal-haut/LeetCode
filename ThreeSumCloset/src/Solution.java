import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		
		int result = 0;
		int diff=-1;
		int count = 0;
		
		for (int i=0; i< num.length -2; i++) {
			if (i == 0 || num[i] != num[i-1]) {
				for (int j = i + 1, k = num.length - 1; j < k;) {
					count++;
					if (num[i] + num[j] + num[k] == target) {
						return target;
					} else {
						int diffT = target - num[j] - num[k] - num[i];
						if (count == 1 || Math.abs(diffT) < diff) {
							diff = Math.abs(diffT);
							result = num[i] + num[j] + num[k];
						} else if (diffT > 0) {
							while(j<k && num[j+1] == num[j]) j++;
							j++;
						} else {
							while(j<k && num[k] == num[k-1]) k--;
							k--;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {0,2,1,-3};
		Solution solution = new Solution();
		System.out.println(solution.threeSumClosest(num, 1));
	}
}
