package fourth;
public class Solution {
	//这是解法二的升级版本，比解法二少交换了几次，少的次数即gcd的次数
	public void rotate(int[] nums, int k) {
		if(nums.length <= 1){
            return;
        }
        int step = k % nums.length;
        //计算gcd
        int gcd = findGcd(nums.length, step);
        int position, count;

        //所以总共要交换gcd ＊ (nums.length / gcd - 1),例如9，6，gcd＝3，那么需要交换6次，很好理解
        for(int i = 0; i < gcd; i++){
            //beginning position of each path，这里就是余数为0，1……gcd－1为止
        	//一个循环下来被涉及到的交换位置都是这个余数范围的
            position = i;
            //count is the number we need swap each path
            count = nums.length / gcd - 1;
            for(int j = 0; j < count; j++){
                position = (position + step) % nums.length;
                //swap index value in index i and position
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
	}
	
	public int findGcd(int a, int b){
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
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
