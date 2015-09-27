package BinaryTreeProblem;

import java.util.ArrayList;

public class SearchRangeinBST {
	//法一：全局变量, results 的作用域
	private ArrayList<Integer> results;
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		results = new ArrayList<Integer>();
		helper(root, k1, k2);
		return results;
	}
	private void helper(TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.val > k1) {
			helper(root.left, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			results.add(root.val);
		}
		if (root.val < k2) {
			helper(root.right, k1, k2);
		}
	}

	// 法二： 把result传进helper，不用全局变量
	// public ArrayList<Integer > searchRange(TreeNode root, int k1, int k2) {
		//     ArrayList<Integer> result = new ArrayList<Integer>();
		//     helper(result, root, k1, k2);
	//     return result;
	// }
	// 
	// private void helper(ArrayList<Integer> result, TreeNode root, int k1, int k2) {
	//     if (root == null) {
	//         return;
	//     }
	//     if (root.val > k1) {
	//         helper(result, root.left, k1, k2);
	//     }
	//     if (root.val >= k1 && root.val <= k2) {
	//         result.add(root.val);
	//     }
	//     if (root.val < k2) {
	//         helper(result, root.right, k1, k2);
	//     }
	// }
}
