package Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import BinaryTreeProblem.TreeNode;



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

		/*
		 * Balanced Tree
		 *                                                                                                                                                     需要同时返回两个参数的经典case
		 * 值得多研究
                                                                                                                                                                                                                                                                                              
		 */
		public boolean isBalanced(TreeNode root) {
			return maxDepth(root) != -1;
		}

		private int isBlancehelper(TreeNode root) {
			if (root == null) {
				return 0;
			}

			int left = isBlancehelper(root.left);
			int right = isBlancehelper(root.right);
			if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
				return -1;
			}
			return Math.max(left, right) + 1;
		}

		// wrapper method
		public class resInfo{
			public int height;
			public boolean isValid;
			public resInfo(int height, boolean isValid){
				this.isValid = isValid;
				this.height = height;
			}
		}
		public boolean isBalancedII( TreeNode root){
			return isBalancedIIHelper(root).isValid;	 
		}
		public resInfo isBalancedIIHelper( TreeNode root){
			if(root == null) {
				return new resInfo(0, true);
			}
			if( root.left == null && root.right == null){
				return new resInfo(1, true);
			}

			resInfo left = isBalancedIIHelper(root.left);
			resInfo right = isBalancedIIHelper(root.right);

			boolean isBalanced = left.isValid && right.isValid && Math.abs(left.height - right.height) <= 1;

			return new resInfo(1+Math.max(left.height, right.height), isBalanced);

		}

		//Divide and conquer 思路
		//返回时base case 什么情况下true 什么情况下false要想清楚
		public boolean isValidBST(TreeNode root) {
			return isValidBSTHelper( (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1, root);
		}
		public boolean isValidBSTHelper( long min, long max, TreeNode root){
			if ( root == null ) return true;
			if( root.val <= min || root.val >= max) return false;
			boolean left = isValidBSTHelper(min, root.val, root.left);
			boolean right = isValidBSTHelper(root.val, max, root.right);

			return left && right;
		}

		//只有当左子树存在时才将它插入右子树中
		//返回尾部元素时，需要特殊处理 (1) 有右子树的情况，(2) 无右子树但有左子树的情况，(3)左右子树均不存在的情况。
		//how to do it withour recursive?
		//other method 1) 老曹讲义 2）http://segmentfault.com/a/1190000003757198

		public void flatten(TreeNode root) {
			flattenHelper(root);
		}
		TreeNode flattenHelper( TreeNode root){
			if (root == null) return null;
			TreeNode leftTail = flattenHelper(root.left);
			TreeNode rightTail = flattenHelper(root.right);

			if (root.left != null){				
				leftTail.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			if(rightTail != null) {
				return rightTail;
			} else if(leftTail != null) {
				return leftTail;
			}
			return root;
		}
		//注意new的位置不一样 会导致输出出错
		//多想想传进去的参数是什么
		//第二种方法 在coner case   rst.add(new String(sb.substring(0, sb.length() - 2)));
		//StringBuilder
		public List<String> binaryTreePaths(TreeNode root) {
			List<String> res = new ArrayList<String>();
			if (null == root) { return res;}
			BTPhelper(res, new StringBuilder(), root);
			return res;    	
		}
		private void BTPhelper(List<String> res, StringBuilder s, TreeNode root){
			if(root.left == null && root.right == null){
				s.append(root.val);
				res.add(s.toString());
				return;
			}
			if( root.left != null){
				BTPhelper(res, new StringBuilder(s).append(root.val).append("->"), root.left);
			}
			if( root.right != null){
				BTPhelper(res, new StringBuilder(s).append(root.val).append("->"), root.right);
			}
		}
		//String
		public List<String> binaryTreePathsI(TreeNode root) {
			List<String> res = new ArrayList<String>();
			if (null == root) { return res;}
			BTPhelperI(res, String.valueOf(root.val), root);
			return res;    	
		}
		private void BTPhelperI(List<String> res, String s, TreeNode root){
			if(root.left == null && root.right == null){
				res.add(s);
				return;
			}
			if( root.left != null){
				BTPhelperI(res, s + "->" + root.left.val, root.left);
			}
			if( root.right != null){
				BTPhelperI(res, s + "->" + root.right.val, root.right);
			}
		}

		//MaxPathSum
		//PathSum 一定要考虑负数的case
		//还可以用array，wrapper来解决
		private  int max = Integer.MIN_VALUE; // object variable
		public int maxPathSum(TreeNode root) {
			if(root==null) return 0; // cannot be ignored
			maxPathSumhelper(root);
			return max;
		}

		private int maxPathSumhelper(TreeNode node) {
			if(node==null) return 0;
			// recursively get sum of left and right path
			int lVal = Math.max(maxPathSumhelper(node.left), 0); // genius!
			int rVal = Math.max(maxPathSumhelper(node.right), 0);
			// update maximum
			//子树的最大值与原max比较
			max = Math.max(node.val+lVal+rVal, max);
			// return sum of largest path of current node
			//考虑root的情况，只加子树最大的一支
			return node.val + Math.max(lVal, rVal);
		}

		//遇到BST第一反应是range
		//mid = start +  (end-start)/2;
		//注意考虑边界情况 奇数偶数的处理 Calm down 比想象的简单
		//new TreeNode的方法 TreeNode root = new TreeNode(A[mid]);
		public TreeNode sortedArrayToBST(int[] A) {
			if (A.length == 0) {
				return null;
			}
			return sortedArrayToBSTHelper(0, A.length, A);
		}


		TreeNode sortedArrayToBSTHelper(int start, int end, int[] A){
			if(start >= end) return null;

			int mid = start + (end-start)/2;
			TreeNode root = new TreeNode(A[mid]);

			root.left = sortedArrayToBSTHelper(start, mid, A);
			root.right = sortedArrayToBSTHelper(mid+1, end , A);
			return root; 
		}

		//这是很有意思的一个题。刚拿到这题的时候，完全不知道从那下手，因为对于BST是否Unique，很难判断。
		//最后引入了一个条件以后，立即就清晰了，即
		//当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
		//以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。

		/*定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目，

		如果数组为空，毫无疑问，只有一种BST，即空树，
		Count[0] =1

		如果数组仅有一个元素{1}，只有一种BST，单个节点
		Count[1] = 1

		如果数组有两个元素{1,2}， 那么有如下两种可能
		1                       2
		  \                    /
		    2                1
		Count[2] = Count[0] * Count[1]   (1为根的情况)
		                  + Count[1] * Count[0]  (2为根的情况。

		再看一遍三个元素的数组，可以发现BST的取值方式如下：
		Count[3] = Count[0]*Count[2]  (1为根的情况)
		               + Count[1]*Count[1]  (2为根的情况)
		               + Count[2]*Count[0]  (3为根的情况)

		所以，由此观察，可以得出Count的递推公式为
		Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
		问题至此划归为一维动态规划。*/
		public int numTrees(int n) {
			//why n+1
			int[] count = new int[n + 1];
			count[0] = 1;
			count[1] = 1;

			for( int i = 2; i <= n; i++){
				for(int j = 0; j < i; j++){
					count[i] = count[i] + count[j]*count[i-j-1];
				}
			}
			return count[n];
		}

		//Pathnum II


		//Lowest common ancestor
		public TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
			if (root == null || root == A || root == B) {
				return root;
			}

			// Divide
			TreeNode left = LCA(root.left, A, B);
			TreeNode right = LCA(root.right, A, B);

			// Conquer
			//下面的逻辑比较麻烦 也可以改成
			//				if (left != null && right != null) {
			//					return root;
			//				} 
			//				if (left != null) {
			//					return left;
			//				}
			//				if (right != null) {
			//					return right;
			//				}
			//传给上一层的东西是通过我当前层决定的，不同情况的当前层返回的value不同
			if (left == null) {
				return right;
			}
			if (right == null) {
				return left;
			}
			if (left != null && right != null) {
				return root;
			} 
			return null;
		}

		//	    Lowest Common Ancestor of a Binary Search Tree

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if(root == null || p == root || q == root){
				return root;
			}

			if(root.val > p.val && root.val < q.val){
				return root;  
			}
			if(root.val>p.val && root.val > q.val){
				return lowestCommonAncestor(root.left, p, q);
			}
			if(root.val<p.val && root.val < q.val){
				return lowestCommonAncestor(root.right, p, q);
			}

			return root;
		}


		//Symmetric Tree
		//很好的一个练逻辑的题
		//conner case & base case没有想出来
		//recursive 
		public boolean isSymmetric(TreeNode root) {
			if(root == null) return true;
			if(root.left == null && root.right == null) return true;
			return isSymhelper(root.left, root.right);
		}
		boolean isSymhelper(TreeNode l, TreeNode r){
			//注意单边没有值在下面的case里面没有考虑到 要处理一下
			if(l == null && r == null) {
				return true;
			} else if(l == null||r == null){
				return false;
			}
			if(l.val != r.val) return false;
			return isSymhelper(l.left, r.right) && isSymhelper(l.right, r.left);
		}

		//Iterative

		//Construct Binary Tree from Inorder and Postorder Traversal
		//	    Construct Binary Tree from Preorder and Inorder Traversal



		  //范围什么的比较易错 以左右子树的长度来说最为保险
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	if( preorder == null || inorder ==null || preorder.length != inorder.length){
	    		return null;
	    	}
	    	return myTreeBuilder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	    }

		private TreeNode myTreeBuilder(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
			if(pStart > pEnd || iStart > iEnd){
				return null;
			}
			TreeNode root = new TreeNode(preorder[pStart]);
			int rIndex = getIndex(inorder, iStart, iEnd, preorder[pStart]);
			if(rIndex==-1) return null;

			
			root.left = myTreeBuilder(preorder, pStart + 1, rIndex + pStart - iStart , inorder,iStart ,rIndex - 1);
			root.right = myTreeBuilder(preorder,pEnd - iEnd + rIndex +1 ,pEnd , inorder,rIndex + 1, iEnd);
	    	return root;
	    }
	    int getIndex( int[] inorder, int start, int end, int val){
	    	for( int i = start; i <= end; i++){
	    		if(inorder[i] == val){
	    			return i;
	    		}
	    	}
	    	return -1;
	    }
	    
	    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
	    	if( postorder == null || inorder ==null || postorder.length != inorder.length){
	    		return null;
	    	}
	    	return myTreeBuilder(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
	    }

		private TreeNode myTreeBuilderPostIn(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
			if(pStart > pEnd || iStart > iEnd){
				return null;
			}
			TreeNode root = new TreeNode(postorder[pEnd]);
			int rIndex = getIndex(inorder, iStart, iEnd, postorder[pEnd]);
			if(rIndex==-1) return null;

			
			root.left = myTreeBuilderPostIn(postorder, pStart, rIndex - 1 - iStart + pStart, inorder,iStart ,rIndex - 1);
			root.right = myTreeBuilderPostIn(postorder, pEnd - iEnd + rIndex+ 1, pEnd - 1, inorder, rIndex + 1, iEnd);
	    	return root;
	    }
	    

	}
}





