package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dicussion看到的算法，避免使用了hashset去重
public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] != num[i - 1]) { //这里的判断可以让重复的结果不再计算，因为第一个数字相同时，第二次计算的结果和第一次计算的结果是相同的
				int j = i+1;
				int k = num.length - 1;
				while (j < k) {
					if (num[i] + num[j] + num[k] == 0) {
						List<Integer> temp = Arrays.asList(num[i],num[j],num[k]);
						result.add(temp);
						while (j < k && num[j] == num[j+1]) //这里的判断可以让重复的结果不再计算，因为第一个数字相同时，第二次计算的结果和第一次计算的结果是相同的
							j++;
						while (j < k && num[k] == num[k-1]) //这里的判断可以让重复的结果不再计算，因为第一个数字相同时，第二次计算的结果和第一次计算的结果是相同的
							k--;
						j++;
						k--;
					} else {
						int left = 0 - num[i];
						if (num[j] + num[k] < left) {
							j++;
						} else {
							k--;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 0, 1, 2, -1, -4, -1};
		Solution solution = new Solution();
		List<List<Integer>> result = solution.threeSum(num);
		for (List<Integer> list : result) {
			for (Integer it : list) {
				System.out.print(it + " ");
			}
			System.out.println();
		}
	}
}
