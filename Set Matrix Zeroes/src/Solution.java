import java.util.HashSet;
import java.util.Set;

public class Solution {
	public void setZeroes(int[][] matrix) {
		Set<Integer> row = new HashSet<Integer> ();
		Set<Integer> column = new HashSet<Integer> ();
		
		for (int i = 0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		
		for (Integer iter : row) {
			for (int k = 0; k < matrix[0].length; k++) {
				matrix[iter][k] = 0;
			}
		}
		
		for (Integer iter : column) {
			for (int k = 0; k < matrix.length; k++) {
				matrix[k][iter] = 0;
			}
		}
	}
}
