package BinaryTreeProblem;

/**
 * Copyright Brantly Walker & Meng Jia
 * Sep 10, 2015
 */

/**
 * @author pingguo
 *
 */
public class findMax_MinDepth {
	public static class TreeNode {
	    int val;
		TreeNode left, right;
		public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
		 }
	}
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    //找最小值时注意特殊情况
    public static int minDepth(TreeNode root) {
        if( root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);

      if(left ==0 && right ==0)  
        return 1;  
      if(left ==0)  
      {  
        left = Integer.MAX_VALUE;  
      }  
      if(right ==0)  
      {  
        right = Integer.MAX_VALUE;  
      }  
      return Math.min(left, right) +1;  
    }
    public static void main(String[] args) {

    	  TreeNode root = new TreeNode(0);
    	  
          root.left = new TreeNode (2);
          root.right = new TreeNode (3);
          root.left.left = new TreeNode (4);
          root.left.right = new TreeNode (5);
          root.left.right.right = new TreeNode (8);
          root.left.right.left = new TreeNode (7);
    
    	System.out.println(maxDepth(root));
    	System.out.println(minDepth(root));

    }
}
