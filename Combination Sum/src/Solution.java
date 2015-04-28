import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> result;
	public List<Integer> solution; 
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			Calc(candidates, target-candidates[index], index);
			solution.remove(solution.size() - 1);
			while (index <candidates.length && candidates[index] == candidate) index++;
		}
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
