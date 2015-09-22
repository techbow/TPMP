package BinaryTreeProblem;

import BinarySearchProblem.TreeNode;
/*当碰到二叉树的问题，一定要先想想如何利用递归的优势来解决！
 * 这里针对每一个节点，需要找到该节点左（右）子树中的以左（右）子节点为起始的最大值路径。
 * 这个过程中需要考虑如何保存过程中的结果，有两种方法分别对应解法一和解法二。
 * L-sub + Node
 * R-sub + Node
 * L-sub + Node + R-sub
*/
public class maxPath {
	    /**
	     * 法一：用全局变量
	     */
	    private static int max = Integer.MIN_VALUE; // object variable
	    public static int maxPathSum0(TreeNode root) {
	        if(root==null) return 0; // cannot be ignored
	        helper(root);
	        return max;
	    }
	 
	    private static int helper(TreeNode node) {
	        if(node==null) return 0;
	        // recursively get sum of left and right path
	        int lVal = Math.max(helper(node.left), 0); // genius!
	        int rVal = Math.max(helper(node.right), 0);
	        // update maximum
	        //子树的最大值与原max比较
	        max = Math.max(node.val+lVal+rVal, max);
	        // return sum of largest path of current node
	        //考虑root的情况，只加子树最大的一支
	        return node.val + Math.max(lVal, rVal);
	    }
	    /**
	     * 法二：用array（obj）
	     * 将传入参数变为长度为1的数组，这样传入的参数属于pass by reference，数组里面的值会随着递归的调用而改变。
	     */
		 
	       public static int maxPathSum1(TreeNode root) {
	           if(root==null) return 0; // can not be ignored!
	           int[] max = {Integer.MIN_VALUE};
	           helper2(root, max);
	           return max[0];
	       }	   
	       private static int helper2(TreeNode node, int[] max) {
	           if(node==null) return 0;
	           // recursively get sum of left and right path
	           int lVal = helper2(node.left, max);
	           int rVal = helper2(node.right, max);
	           int current = Math.max(node.val, Math.max(node.val+lVal, node.val+rVal));
	           // update maximum
	           max[0] = Math.max(max[0], Math.max(current, node.val+lVal+rVal));
	           // return sum of largest path of current node
	           return current;
	       }	   
	    public static void main(String[] args) {

//	    	  TreeNode root = new TreeNode(0);
	    	  TreeNode root = new TreeNode(3);
	    	  
	          root.left = new TreeNode (2);
	          root.right = new TreeNode (3);
	          root.left.left = new TreeNode (4);
	          root.left.right = new TreeNode (5);
//	          root.left.right.right = new TreeNode (8);
//	          root.left.right.left = new TreeNode (7);
	    
	    	System.out.println(maxPathSum1(root));
	    }
	 
	}
