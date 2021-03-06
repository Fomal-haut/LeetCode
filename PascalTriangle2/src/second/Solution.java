package second;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//这里主要是对一个方法的认识add(index, value)
	//如果index已经有值，则会插到它的下一个		
	public List<Integer> getRow(int rowIndex) {
	    List<Integer> list = new ArrayList<Integer>();
	    if (rowIndex < 0)
	        return list;

	    for (int i = 0; i < rowIndex + 1; i++) {
	        list.add(0, 1);
	        for (int j = 1; j < list.size() - 1; j++) {
	            list.set(j, list.get(j) + list.get(j + 1));
	        }
	    }
	    return list;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> aa = solution.getRow(2);
		
		for (Integer it : aa) {
			System.out.println(it);
		}
	}
}
