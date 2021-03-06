package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	//动态规划解决方案
	//这里公式是算出1-t的各种组合情况，其实f(t) =f(1)->f(t-1) + n (注意 这里的n要小于f组合里最小的数，这是为了去重) 
	//上面的循环是从n开始，由1起始，再去判断对应的f里元素是否最小的数大于n的值
    public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList<List<Integer>>(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List<Integer> cl = new ArrayList<Integer>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
    
    public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		Solution solution = new Solution();
		List<List<Integer>> a = solution.combinationSum(candidates, 7);
		
		for (List<Integer> l : a) {
			for (Integer w : l) {
				System.out.print(w + " ");
			}
			System.out.println();
		}
	}
}
