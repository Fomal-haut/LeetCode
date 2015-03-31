
public class Solution {
	public int removeElement(int[] A, int elem) {
		int x = 0;
		int y = A.length - 1;
		
		while (x <= y) {
			if (A[x] == elem) {
				while (y > x && A[y] == elem) {
					y--;
				}
				A[x] = A[y];
				y--;
			} 
			x++;
		}
		return y+1;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] Aa = new int[2];
		Aa[0] = 1;
		Aa[1] = 1;
		int result = sol.removeElement(Aa, 1);
		System.out.println(result);
		
	}
}
