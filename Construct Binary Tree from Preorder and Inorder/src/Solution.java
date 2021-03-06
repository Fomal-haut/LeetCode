
public class Solution {
	//递归写的算法，比较普通
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode rebuild(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
		int root = preorder[pstart];
		TreeNode rootNode = new TreeNode(root);
		if (pend - pstart == 0) {
			return rootNode;
		}
		
		int position = findPos(root, inorder, istart, iend);
		int length = position - istart;
		if (length != 0) {
			TreeNode leftNode = rebuild(preorder, pstart+1, pstart+length, inorder, istart, position-1);
			rootNode.left = leftNode;
		}
		
		if (position != iend) {
			TreeNode rightNode = rebuild(preorder, pstart+1+length, pend, inorder, position+1, iend);
			rootNode.right = rightNode;
		}
		
		return rootNode;
	}

	private int findPos(int root, int[] inorder, int istart, int iend) {
		for (int i = istart; i<=iend; i++) {
			if (root == inorder[i]) {
				return i;
			}
		}
		return -1;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		return rebuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2};
		int[] inorder = {1,2};
		Solution solution = new Solution();
		solution.buildTree(preorder, inorder);
	}
}
