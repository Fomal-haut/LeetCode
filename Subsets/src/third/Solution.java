package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	//位图计算，网上摘抄，十分精妙
	//求子集问题就是求组合问题。
	//数组中的n个数可以用n个二进制位表示，当某一位为1表示选择对应的数，为0表示不选择对应的数。
	public List<List<Integer>> subsets(int[] nums) {
		 //n个数有0~max-1即2^n中组合，1<<n表示2^n
		int n = nums.length;
		Arrays.sort(nums);
	    int max = 1<<n;
	    List<List<Integer>> result = new ArrayList<>();
	    for(int i = 0;i < max;i++)
	    {
	      List<Integer> temp = new ArrayList<Integer>();
	      int idx = 0;
	      int j = i;
	      while(j > 0)
	      {
	        //判断最后一位是否为1，若为1则将对应数加入到当前组合中
	        if((j&1)==1)
	        {
	          temp.add(nums[idx]);
	        }
	        idx++;
	        //判断了这一位是否为1后要右移
	        j = j>>1;
	      }
	      //判断完了一种组合，加入到结果集中
	      result.add(temp);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {4,1,0};
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
