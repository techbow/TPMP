package BinaryTreeProblem;

import BinarySearchProblem.TreeNode;

public class isSymmetric {

	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		return isSymhelper(root.left, root.right);
	}
	static boolean isSymhelper(TreeNode l, TreeNode r){
		
		//注意单边没有值在下面的case里面没有考虑到 要处理一下
		if(l == null && r == null) {
			return true;
		} else if(l == null||r == null)
            return false;
		
		if(l.val != r.val) return false;

		return isSymhelper(l.left, r.right) && isSymhelper(l.right, r.left);
	}
	public static void main(String[] args) {
		/*    
            1  
           / \  
          2   3  
         /     \  
        4       6     
     
	   */  
		//TreeNode r0 = new TreeNode(0);
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(2);
		TreeNode r4 = new TreeNode(4);
		//TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(4);
		//TreeNode r7 = new TreeNode(7);

		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		//r2.right = r5;
		r3.right = r6;


		System.out.println(isSymmetric(r1));
	}
}
