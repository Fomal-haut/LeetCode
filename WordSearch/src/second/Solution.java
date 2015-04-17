package second;

public class Solution {
	//非常巧妙的O（1）空间方法
	//将走过的字母异或256，因为char是8位，256是第九位是1，其余是0，所以异或后肯定不是26个字母之一了。
	//回溯的时候，再异或256就能回来，不用额外空间计算走的状态，非常巧妙
	public boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	        for (int x=0; x<board[y].length; x++) {
	            if (exist(board, y, x, w, 0)) return true;
	        }
	    }
	    return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	    if (i == word.length) return true;
	    if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
	    if (board[y][x] != word[i]) return false;
	    board[y][x] ^= 256;
	    boolean exist = exist(board, y, x+1, word, i+1)
	        || exist(board, y, x-1, word, i+1)
	        || exist(board, y+1, x, word, i+1)
	        || exist(board, y-1, x, word, i+1);
	    board[y][x] ^= 256;
	    return exist;
	}
}
