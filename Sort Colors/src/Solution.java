public class Solution {
	//三指针问题
	//one-pass
	//从左右两边开始，left代表0和1的交界处，1的开头，准备要和A[i]为0的进行交换
	//right代表1和2的交界处，2的开头，准备要和A[i]为2的进行交换
	public void sortColors(int[] A) {
		int left = 0;
		int right = A.length - 1;
		int i = 0;
		
		while (i <= right) {
			if (A[i] == 0) {
				swap(A, left, i);
				i++;
				left++;
			} else if (A[i] == 1) {
				i++;
			} else {
				swap(A, right, i);
				right--;
			}
		}
		
	}
	
	public void swap(int[] A, int a, int b) {
		if (a==b) return;
		A[a] = A[a]^A[b];
		A[b] = A[a]^A[b];
		A[a] = A[a]^A[b];
	}
	
	public static void main(String[] args) {
		int[] num = {2,1,1,2,0,0,1,1,2,2,1};
		Solution solution = new Solution();
		solution.sortColors(num);
		for (Integer i : num) {
			System.out.println(i + " ");
		}
	}
}

