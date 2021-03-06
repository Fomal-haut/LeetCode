import java.util.Arrays;

public class Solution {
	//  因为是寻找组合数中下一个比自己大，但是最接近的数字
	//  所以解题思路即是从最低位找起，逐步去找比它小的位数上最接近的数字，找到后进行替换，然后将余下的部分进行从小到大排序
	
	public void nextPermutation(int[] num) {
		for (int j=num.length-2; j>=0; j--) {
			int temp=j;
			for (int k=j+1; k<num.length; k++) {
				if (temp == j) {
					if (num[temp] < num[k]) {
						temp = k;
					}
				}
				else if(num[temp] > num[k] && num[k] > num[j]){
					temp = k;
				}
			}
			if (temp != j) {
				num[temp] = num[j] + num[temp];
				num[j] = num[temp] - num[j];
				num[temp] = num[temp] - num[j];
				Arrays.sort(num, j+1, num.length);
				return;
			}
		}
		Arrays.sort(num);
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,5};
		Solution solution = new Solution();
		solution.nextPermutation(num);
		
		for (int i : num) {
			System.out.println(i);
		}
	}
}
