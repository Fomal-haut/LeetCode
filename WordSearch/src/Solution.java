import java.util.Vector;

public class Solution {
	public int width;
	public int height;
	public boolean exist(char[][] board, String word) {
		width = board[0].length;
		height = board.length;
		boolean[][] isOccupied = new boolean[height][width];//记录状态
		Vector<Integer> vector = new Vector<>();
		
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (board[i][j] == word.charAt(0)) {
					vector.add(i);
					vector.add(j);
				}
			}
		}
		
		int times = vector.size() / 2;
		
		for (int i=0; i<times; i++) {
			if(search(board, word, vector.get(2*i), vector.get(2*i+1), 0, isOccupied) == true) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean search(char[][] board, String word, int x, int y, int index, boolean[][] isOccupied) {
		if (index >= word.length())
			return true;
		if (x < 0 || y < 0 || x >= height || y>=width)
			return false;
		if (board[x][y] != word.charAt(index) || isOccupied[x][y] == true) {
			return false;
		}
		isOccupied[x][y] = true;
		if (search(board, word, x-1, y, index+1, isOccupied) == true) return true;
		if (search(board, word, x, y-1, index+1, isOccupied) == true) return true;
		if (search(board, word, x, y+1, index+1, isOccupied) == true) return true;
		if (search(board, word, x+1, y, index+1, isOccupied) == true) return true;
		
		isOccupied[x][y] = false;
		return false;
	}
	
	public static void main(String[] args) {
		char[][] tt = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		Solution solution = new Solution();
		System.out.println(solution.exist(tt, "ABCCED"));
		
	}
}
