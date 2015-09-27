package BinaryTreeProblem;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.List;

import BinarySearchProblem.TreeNode;

public class pathSumII {
	//DFS by using recursion, remember when iterate one path, 
	//we should remove the last node from the list.
	//这类int求和问题都可能存在overflow的问题。需要和面试官交流明确是否程序中要检查。
	public static ArrayList<ArrayList<Integer>> pathSum( TreeNode root, int sum){

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		if( root == null) return null;
		
		s.push(root.val);
		while(!s.isEmpty() && root!= null){
			if(root.left == null && root.right == null && root.val == sum){
				res.add(new ArrayList<Integer>(path));			
				}
		}
		
		return res;
	}

	public static ArrayList<ArrayList<Integer>> pathSum1( TreeNode root, int sum){

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper1(root, res, path, sum);
		return res;
	}
	private static void helper1( TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int sum ){
		if( root == null) return;
		path.add(root.val);
		if(root.left == null && root.right == null && root.val == sum){
			//			ArrayList<Integer> temp = new ArrayList<Integer>();
			//	        temp.addAll(path);
			//	        res.add(temp);
			//java obj都是pass by reference，注意进行deep clone
			res.add(new ArrayList<Integer>(path));			
		}
		helper1(root.left, res, path, sum-root.val);
		helper1(root.right, res, path, sum-root.val);
		//Path Sum II中要注意ln 25对path的reset。无论递归是否结束，或者解是否找到，都不能在返回前遗漏这一步reset。
		//因为通过当前节点的所有path已经都访问到了，返回前需要从path中删除当前节点，以便重新构建其他path。
		path.remove(path.size()-1);
	}
////	Solution 2
////	Another solution by using DFS – Recusion, but more easy to make mistake.
////
////	We should check null element in the main method (contract with solution 1)
////	We should first add the root.val into the temp list to avoid the situation: the input tree has just one node.
////	the argument in the helper2() should be sum - root.val rather than sum
////	in the edge case of helper2() method, we should create a new ArrayList of temp, rather than add temp into res directly.
//
//	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
//	   List<List<Integer>> res = new ArrayList<List<Integer>>();
//	   if (null == root) {
//	       return res;
//	   }
//	   List<Integer> temp = new ArrayList<Integer>();
//	   temp.add(root.val);
//	   helper2(root, res, temp, sum - root.val);
//	   return res;
//	}
//	 
//	private void helper2(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
//	   if (null == root.left && null == root.right && sum == 0) {
//	       res.add(new ArrayList<Integer>(temp));
//	       return;
//	   }
//    //search path of left node
//	   if (root.left != null) {
//	       temp.add(root.left.val);
//	       helper2(root.left, res, temp, sum - root.left.val);
//	       temp.remove(temp.size() - 1);
//	   }
//  //search path of right node
//	   if (root.right != null) {
//	       temp.add(root.right.val);
//	       helper2(root.right, res, temp, sum - root.right.val);
//	       temp.remove(temp.size() - 1);
//	   }
//	}
	 
	public static void main(String[] args) {

		//	  TreeNode root = new TreeNode(0);
		TreeNode root = new TreeNode(3);

		root.left = new TreeNode (2);
		root.right = new TreeNode (3);
		root.left.left = new TreeNode (4);
		root.left.right = new TreeNode (5);
		//      root.left.right.right = new TreeNode (8);
		//      root.left.right.left = new TreeNode (7);

		System.out.println(pathSum(root,10));
	}

}
