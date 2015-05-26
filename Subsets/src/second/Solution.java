package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// 网上摘录，是一种递归的思想，递归中还包含着简单的动态规划，因为Subset(n)= Subset(n-1)+(n itself) +(add n to Subset(n-1))
	
	public List<List<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
		Arrays.sort(S);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = getSubSet(S, S.length - 1);
		result.add(new ArrayList<Integer>());
		return result;
	}

	List<List<Integer>> getSubSet(int[] s, int index) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (index < 0) {
			return result;
		}
		List<List<Integer>> subResult = getSubSet(s, index - 1);
		result.addAll(subResult);
		for (int i = 0; i < subResult.size(); i++) {
			List<Integer> bList = new ArrayList<>();
			bList.addAll(subResult.get(i));
			bList.add(s[index]);
			result.add(bList);
		}
		result.add(Arrays.asList(s[index]));
		return result;
	}
}
