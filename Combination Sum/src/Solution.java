import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	//感觉一般回溯都是用递归写比较方便
	//会纪录一个步step，来纪录递归的深度，方便回溯，这里就是Calc的index
	//如果需要纪录路径，则需要一个容器，这里就是solution，并且在回溯的时候还需要对其进行类似出栈入栈的操作
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
