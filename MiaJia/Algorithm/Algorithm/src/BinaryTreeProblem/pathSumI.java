package BinaryTreeProblem;

import BinarySearchProblem.TreeNode;
//relative: 
//path sum II 
//Combination Sum

/*
 * Analysis:
 * Very classic recursive problem.
 * Check every path of the tree (recursively), with the sum, 
 * if find the leaf node with sum==0, then return true.
 * 
 * The way of thinking this problem:
 * (1) The question requires only true/false return, so the 
 *     final result is the || operation of all the possible path.
 *     The return value of the recursion is  
 *     go root.left  ||  go root.right
 *     
 * (2) Parameters used in recursion, only the sum and the current node.
 * (3) Condition:   if the sum == 0 and the node is leaf node return true,
                    if the sum != 0 and the node is NULL, return false
                    else return
                    go root.left, sum-val || go root.right, sum-val
    How to define the leaf node? An idea is check the left and right children, 
    all are NULL, then it's a leaf node.
 */
public class pathSumI {
	public static boolean hasPathSum(TreeNode root, int sum) {
		String a = "sdf";
		a.c
		if (root== null) {
			return false;
			}
		if ( (root.left == null) && (root.right == null) && (sum == root.val) ) {
			return true;
			}
		return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
	}
	public static void main(String[] args) {

//  	  TreeNode root = new TreeNode(0);
  	  TreeNode root = new TreeNode(3);
  	  
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        root.left.left = new TreeNode (4);
        root.left.right = new TreeNode (5);
//        root.left.right.right = new TreeNode (8);
//        root.left.right.left = new TreeNode (7);
  
  	System.out.println(hasPathSum(root,11));
  }
}

