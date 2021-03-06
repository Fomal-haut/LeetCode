public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowSize = matrix.length;
		int columnSize = matrix[0].length;
		
		int low = 0;
		int high = rowSize - 1;
		
		while (low < high) {
			int mid = (low + high) / 2;
			if (matrix[mid][0] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		int rowId;
		if (matrix[high][0] > target) {
			rowId = high - 1;
		} else {
			rowId = high;
		}
		
		low = 0;
		high = columnSize - 1;
		if (rowId < 0) {
			return false;
		}
		while (low < high) {
			int mid = (low + high) / 2;
			if (matrix[rowId][mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		if (matrix[rowId][high] == target) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
//		int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}};
		int[][] matrix = {{1}};
		Solution solution = new Solution();
		System.out.println(solution.searchMatrix(matrix, 0));
		
	}
}
