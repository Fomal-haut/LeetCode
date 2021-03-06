import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		Arrays.sort(num);
		for (int i=0; i<num.length - 3; i++) {
			if (i ==0 || num[i-1] != num[i]) {
				for (int j=i+1; j<num.length  - 2;j++) {
					if (j == i+1 || num[j-1] != num[j]) {
						for (int k=j+1, m=num.length -1; k<m;) {
							if (num[i] + num[j] + num[k] + num[m] == target) {
								List<Integer> list = new ArrayList<Integer>();
								list.add(num[i]);
								list.add(num[j]);
								list.add(num[k]);
								list.add(num[m]);
								result.add(list);
								do {
									k++;
								} while (num[k] == num[k-1] && k<m);
								
								do {
									m--;
								} while (num[m] == num[m+1] && m>k);
							}
							else {
								if (num[i] + num[j] + num[k] + num[m] < target) {
									k++;
									while (num[k] == num[k-1] && k<m) k++;
								} else {
									m--;
									while (num[m] == num[m+1] && m>k) m--;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {-1,0,-5,-2,-2,-4,0,1,-2};
		List<List<Integer>> result = solution.fourSum(num, -9);
		
		for (List<Integer> list : result) {
			for (Integer it : list) {
				System.out.print(it + " ");
			}
			System.out.println();
		}
	}
}
