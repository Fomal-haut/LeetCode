import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	//回溯的方法
	//这里要注意类对象不能声明成static的，因为leetcode在测试的时候并不是每次重启进程，所以类对象不会清空
	 public  List<List<Integer>> result = new ArrayList<>();
	    
	    public List<List<Integer>> subsets(int[] nums) {
	        result.add(new ArrayList<Integer>());
			Arrays.sort(nums);
			int level = nums.length;
			List<Integer> list = new ArrayList<Integer> ();
			
			for (int i=1; i<=level; i++) {
				calc(i,list, 0, nums);
			}
			
			return result;
	    }
	    
	    public void calc(int length, List<Integer> list, int pointer, int[] nums) {
			
			while (pointer < nums.length) {
				list.add(nums[pointer]);
				if (list.size() == length){
					result.add(new ArrayList<Integer>(list));
				} else {
					calc(length, list, ++pointer, nums);
					pointer--;
				}
				list.remove(list.size() - 1);
				pointer++;
			}
			
		}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3,2,4,1};
		List<List<Integer>> result = solution.subsets(nums);
		System.out.println(result.size());
		for (List<Integer> li : result) {
			for (Integer iter : li) {
				System.out.print(iter + " ");
			}
			System.out.println();
		}
	}
	
}
