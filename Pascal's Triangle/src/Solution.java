import java.util.ArrayList;
import java.util.List;


public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		if (numRows == 0) {
			return result;
		}
		List<Integer> one = new ArrayList<Integer>();
		one.add(1);
		result.add(one);
		if (numRows == 1) {
			return result;
		}
		List<Integer> two = new ArrayList<Integer>();
		two.add(1);
		two.add(1);
		result.add(two);
		
		for (int i=3; i<=numRows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j=1; j<=i; j++) {
				if (j == 1 || j == i) {
					temp.add(1);
				} else {
					temp.add(result.get(i-2).get(j-2) + result.get(i-2).get(j-1));
				}
			}
			result.add(temp);
		}
		
		return result;
	}
	
	public void print(List<List<Integer>> result) {
		for (int i=0; i<result.size(); i++) {
			for (int j=0; j <result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.print(solution.generate(5));
	}
}
