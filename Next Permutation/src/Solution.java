import java.util.Arrays;

public class Solution {
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
