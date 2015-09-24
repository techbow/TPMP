package Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class Tree {
	/*
	 * General Tree
	 * 
	 * Binary Tree
	 * 
	 * Binary Search Tree(BST )
	 * 
	 * 
	 * Definition for regular tree
	 * 	public class TreeNode {
	 *     int val;
	 *     TreeNode[] children;
	 *     TreeNode(int x) { val = x; }
	 *  }
	 *  
	 * Definition for binary tree
	 *  public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 *  }

	 */
	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/*
	 * Traversal:Postorder Traversal, Preorder Traversal, Inorder Traversal, Level Order Traversal
	 * 
	 * Difference between DIVIDE and CONQUER & recursive: 
	 * First have return value other don't have one
	 * 
	 * 当push进栈时，检查是否为null
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if( root == null) return res;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while( root != null || !s.isEmpty()){
			if ( root == null){
				root = s.pop();
			}
			res.add(root.val);
			if(root.right != null) 
				s.push(root.right);
			root = root.left;
		}
		return res;
	}
	//注意在哪里check 
	public List<Integer> preorderTraversalII(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if( root == null) return res;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while( !s.isEmpty()){
			root = s.pop();
			res.add(root.val);
			if(root.right != null) 
				s.push(root.right);
			if(root.left != null) {
				s.push(root.left);
			}
		}
		return res;
	}


	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if( root == null) return res;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while( root != null || !s.isEmpty()){
			if (root == null){//说明走到最后了，只能pop上一层，add后查看右边
				root = s.pop();
				res.add(root.val);
				root = root.right;
			}
			else{
				s.push(root);
				root = root.left;
			}
		}
		return res;
	}
	//Pre-order镜像处理
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if( root == null) return res;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while( root != null || !s.isEmpty()){
			if ( root == null){
				root = s.pop();
			}
			res.add(root.val);
			if(root.left != null) 
				s.push(root.left);
			root = root.right;
		}
		Collections.reverse(res);
		return res;
	}

	/**
	 *two queue solution, remember to make when to add res clear
	 */
	public class Solution {
		public List<ArrayList<Integer>> levelOrder(TreeNode root) {
			List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			if( root == null) return res;
			Queue<TreeNode> par = new LinkedList<TreeNode>();
			Queue<TreeNode> child = new LinkedList<TreeNode>();
			par.offer(root);

			while(!par.isEmpty()){
				root = par.poll();
				list.add(root.val);

				if(root.left != null) child.offer(root.left);
				if(root.right != null) child.offer(root.right);


				if(par.isEmpty()){
					res.add(new ArrayList<Integer>(list));
					list.clear();
					Queue<TreeNode> temp;
					temp = par;
					par = child;
					child = temp;
				}
			}
			return res;
		}

		/*
		 * Binary Tree Zigzag Level Order Traversal
		 * 这种反向输出的题 考虑用add（0，val) 来简化代码
		 * odd and even level
		 */

		/*
		 * Given a binary tree, find its maximum depth.
		 */
		public int maxDepth(TreeNode root) {
			if (root == null){
				return 0;
			}
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return Math.max(left, right) + 1;
		}
		/*注意考虑 只有一边有值的情况
		 * 	  1
			   \ 
			    3
			   / \
			  4   5
		 */
		public int minDepth(TreeNode root) {
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;

			if( root == null) return 0;
			if( root.left == null && root.right == null) return 1;

			if(root.left != null) left = minDepth(root.left);
			if(root.right != null) right = minDepth(root.right);

			return Math.min(left, right) +1;  
		}








	}

}


