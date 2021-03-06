public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private TreeNode rebuild(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend) {
		int root = postorder[pend];
		TreeNode rootNode = new TreeNode(root);
		if (pend - pstart == 0) {
			return rootNode;
		}
		
		int position = findPos(root, inorder, istart, iend);
		int length = position - istart;
		if (length != 0) {
			TreeNode leftNode = rebuild(postorder, pstart, pstart+length-1, inorder, istart, position-1);
			rootNode.left = leftNode;
		}
		
		if (position != iend) {
			TreeNode rightNode = rebuild(postorder, pstart+length, pend-1, inorder, position+1, iend);
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

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}
		return rebuild(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	public static void main(String[] args) {
		int[] postorder = {1,2};
		int[] inorder = {1,2};
		Solution solution = new Solution();
		solution.buildTree(inorder, postorder);
	}
	
}
