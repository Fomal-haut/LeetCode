import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i=0; i<nums.length; i++) {
			if (hashset.contains(nums[i])) {
				return true;
			} else {
				hashset.add(nums[i]);
			}
		}
		return false;
	}
}
