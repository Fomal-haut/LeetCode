package second;

public class Solution {
	//O(1)的空间占有
	//随机的对某个位置来转移，若不用转移，则随机转移到另一个位置，一共进行数组长度次数的转移，能保证每次都处理不同的位置
	public void rotate(int[] a, int k) {
		int N = a.length;
	    k = k%N;
	    int idx = N-1;
	    int temp = N-1;
	    for (int s = 0; s < N-1; s++)
	    {
	            idx = (idx+k)%N;            
	            if(temp == idx)
	            {
	                temp = temp-1;
	                idx = temp;
	                continue;
	            }
	            swap(a,temp,idx);           
	    }
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] number = {1,2,3,4,5,6,7};
		Solution solution = new Solution();
		solution.rotate(number, 2);
		for (int x : number) {
			System.out.println(x);
		}
	}
}
