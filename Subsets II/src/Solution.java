import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// n个数有0~max-1即2^n中组合，1<<n表示2^n
		int n = nums.length;
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();
		
		int max = 1 << n;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			int idx = 0;
			int j = i;
			while (j > 0) {
				// 判断最后一位是否为1，若为1则将对应数加入到当前组合中
				if ((j & 1) == 1) {
					temp.add(nums[idx]);
				}
				idx++;
				// 判断了这一位是否为1后要右移
				j = j >> 1;
			}
			// 判断完了一种组合，加入到结果集中
			set.add(temp);
		}
		
		for (List<Integer> list : set) {
			result.add(list);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,2};
		List<List<Integer>> subsetsWithDup = solution.subsetsWithDup(nums);
		for (List<Integer> list : subsetsWithDup) {
			System.out.println(list);
		}
	}
}
