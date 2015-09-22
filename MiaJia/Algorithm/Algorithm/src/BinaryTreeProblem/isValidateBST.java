package BinaryTreeProblem;

import BinarySearchProblem.TreeNode;

public class isValidateBST {
	/**
	 * @param root: The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public static boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		//使用Long型，避免root的值超出Integer范围后报错
		//EG:{2147483647}
		//这种求数的范围的题时一定要考虑这个情况
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean helper(TreeNode root, long lower, long upper) {
		if(root == null){
			return true;
		}		
		//节点的左子树中的值要严格小于该节点的值。
		//节点的右子树中的值要严格大于该节点的值。
		//所以一定要有等号
		if (root.val <= lower|| root.val >= upper){
			return false;
		}
		//better name:isLeftValidBST
		boolean left = helper(root.left, lower, root.val);
		boolean right = helper(root.right, root.val, upper);
		return left && right;
				
	}


    public static void main(String[] args) {

//  	  TreeNode root = new TreeNode(0);
  	  TreeNode root = new TreeNode(3);
  	  
        root.left = new TreeNode (2);
        root.right = new TreeNode (4);
  //      root.left.left = new TreeNode (4);
        root.right.right = new TreeNode (5);
//        root.left.right.right = new TreeNode (8);
//        root.left.right.left = new TreeNode (7);
  
  	System.out.println(isValidBST(root));
  }
}

