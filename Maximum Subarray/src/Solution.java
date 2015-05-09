public class Solution {
	//最大连续和计算
	//判断之前的和是否为正，是的话，可以继续加，否的话就直接取下一个
    public int maxSubArray(int[] nums) {
    	int maxVal = nums[0];
    	int sum = nums[0];
        for (int i=1;i<nums.length;i++) {
        	if (sum < 0) {
        		sum = nums[i];
        	} else {
        		sum += nums[i];
        	}
        	if (sum > maxVal) {
        		maxVal = sum;
        	}
        }
        
        return maxVal;
    }
    
    public static void main(String[] args) {
		int[] nn = {-2,1,-3,4,-1,2,1,-5,4};
		Solution solution = new Solution();
		System.out.println(solution.maxSubArray(nn));
		
	}
}