import java.util.ArrayList;
import java.util.List;


public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		List<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		
		if (triangle.size() == 0) {
			return 0;
		}
		
		if (n != 1) {
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					dp.set(0, dp.get(0) + triangle.get(i).get(0));
				} else {
					dp.add(0, dp.get(0) + triangle.get(i).get(0));
				}
				for (int j = 1; j < i+1; j++) {
					dp.set(j, triangle.get(i).get(j) +getMin(dp, j ,i));
				}
			}
		} else {
			return triangle.get(0).get(0);
		}
		
		int min = dp.get(0);
		for (int i = 1; i<dp.size(); i++) {
			if (min > dp.get(i)) {
				min = dp.get(i);
			}
		}
		
		return min;
	}

	private Integer getMin(List<Integer> dp, int j, int i) {
		if (j >= i) {
			return dp.get(j);
		} else {
			return dp.get(j) < dp.get(j+1) ? dp.get(j) : dp.get(j+1);
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> list0 = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
//		List<Integer> list2 = new ArrayList<Integer>();
//		List<Integer> list3 = new ArrayList<Integer>();
		list0.add(1);
		list1.add(2);
		list1.add(3);
//		list2.add(6);
//		list2.add(5);
//		list2.add(7);
//		list3.add(4);
//		list3.add(1);
//		list3.add(8);
//		list3.add(3);
		
		List<List<Integer>> totalLists = new ArrayList<List<Integer>> ();
		totalLists.add(list0);
		totalLists.add(list1);
//		totalLists.add(list2);
//		totalLists.add(list3);
		
		System.out.println(solution.minimumTotal(totalLists));
	}
}
