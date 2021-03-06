package third;

public class Solution {
	//O(1)的空间占有
	
	//整个转换步骤，以main函数为例
	//step1:{1,2,3,4,5,6,7} - > {7,6,5,4,3,2,1}
	//step2:{7,6,5,4,3,2,1} - > {5,6,7,4,3,2,1}
	//step3:{5,6,7,4,3,2,1} - > {5,6,7,1,2,3,4}
	public void rotate(int[] nums, int k) {
		if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,step - 1);
        reverse(nums,step,nums.length - 1);
	}
	
	//将int数组的n到m下标内的数颠倒过来
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }
	
	public static void main(String[] args) {
		int[] number = {1,2,3,4,5,6,7};
		Solution solution = new Solution();
		solution.rotate(number, 3);
		for (int x : number) {
			System.out.println(x);
		}
	}
}
