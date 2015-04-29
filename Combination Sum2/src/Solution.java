import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	//一样的回溯，和前面区别就是一个数只能用一次，修改一个地方就可以了，即传递的层数（数组的指针）加1
	public List<List<Integer>> result;
	public List<Integer> solution; 
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		result = new ArrayList<List<Integer>> ();
		solution = new ArrayList<Integer> ();
		Calc(candidates, target, 0);
		
		return result;
	}

	public void Calc(int[] candidates, int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<Integer> (solution));
		}
		if (target < 0) {
			return;
		}
		
		while (index < candidates.length) {
			int candidate = candidates[index];
			solution.add(candidate);
			Calc(candidates, target-candidates[index], index+1);
			solution.remove(solution.size() - 1);
			while (index <candidates.length && candidates[index] == candidate) index++;
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		Solution solution = new Solution();
		List<List<Integer>> a = solution.combinationSum2(candidates, 8);
		
		for (List<Integer> l : a) {
			for (Integer w : l) {
				System.out.print(w + " ");
			}
			System.out.println();
		}
	}
}
