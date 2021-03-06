import java.util.HashMap;
import java.util.Map;


public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		//采用一次循环，用map来记录数值和索引的对应关系
		//根据一个数，再去找target-该数是否存在
		//这里需要注意特殊数据，比如两个相同的数，可以发现题干要求，如果超过两个以上相同的数，就不可能是所要求的index
		//这段代码相同的数据不会插入第二次，如果没有了k<i这个条件，两个相同的数情况就会报错了，因为同一循环内，比如target为4，2插入后，再找4-2，这时候找到的是它自己，就出错了
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<numbers.length; i++) {
			Integer k = map.get(numbers[i]);
			if (k==null) map.put(numbers[i], i);
			k = map.get(target-numbers[i]);
			if (k!=null && k<i) {
				result[0] = k+1;
				result[1] = i+1;
				return result;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] tt = {2,2,0,1};
		Solution solution = new Solution();
		int[] result = solution.twoSum(tt, 4);
		for (int k=0; k<result.length; k++) {
			System.out.println(result[k]);
		}
	}
}
