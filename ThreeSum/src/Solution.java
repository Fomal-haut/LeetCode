import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//kSum方法最优的算法复杂度是： Ω(n^ceil(k/2)) ，ceil为向上舍入函数
//但是quantum算法可以优化到线性级别
//摘自https://leetcode.com/discuss/1760/any-solution-which-is-better-than-o-n-2-exists

public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> hashSet = new HashSet<>();
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			int j = i+1;
			int k = num.length - 1;
			while (j < k) {
				if (num[i] + num[j] + num[k] == 0) {
					List<Integer> temp = Arrays.asList(num[i],num[j],num[k]);
					if (hashSet.add(temp)) { //hashSet可以用来去重，因为它使用了里面list的重载equals的方法
						result.add(temp);
					}
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
