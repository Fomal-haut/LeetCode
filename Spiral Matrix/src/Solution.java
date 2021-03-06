import java.util.ArrayList;
import java.util.List;


public class Solution {
	boolean [][] isOccupied;
	int direction = 4;
	
	public List<Integer> spiralOrder(int [][] matrix) {
		List<Integer> result = new ArrayList<Integer> ();
		if (matrix.length == 0) {
			return result;
		}
		isOccupied = new boolean[matrix.length][matrix[0].length];
		int x = 0;
		int y = 0;
		
		int sum = matrix.length * matrix[0].length;
		
		for (int i = 1; i<=sum;i++) {
			result.add(matrix[x][y]);
			isOccupied[x][y] = true;
			if (direction == 1) {
				if (x+1<matrix.length && isOccupied[x+1][y] == false) {
					x++;
				} else {
					y--;
					direction = 2;
				}
			} else if (direction == 2) {
				if (y-1 >=0 && isOccupied[x][y-1] == false) {
					y--;
				} else {
					x--;
					direction = 3;
				}
			} else if (direction == 3) {
				if (x-1>=0 && isOccupied[x-1][y] == false) {
					x--;
				} else {
					y++;
					direction = 4;
				}
			} else {
				if (y+1 < matrix[0].length && isOccupied[x][y+1] == false) {
					y++;
				} else {
					x++;
					direction = 1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Solution solution = new Solution();
		List<Integer> result = solution.spiralOrder(matrix);
		for (Integer it : result) {
			System.out.print(it);
			System.out.println(" ");
		}
	}
}
