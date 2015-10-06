/*
Given a binary tree, find path between two nodes
*/
public class Solution {
	public List<TreeNode> findPath(TreeNode root, TreeNode n1, TreeNode n2){
		List<TreeNode> path1 = findPathFromRoot(root, n1);
		List<TreeNode> path2 = findPathFromRoot(root, n2);
		TreeNode lca = LCA(root, n1, n2);
		List<TreeNode> fullPath = new ArrayList<TreeNode>();
		for (TreeNode t : path1) {
			if (t == lca) {
				break;
			}
			fullPath.add(t);
		}
		fullPath.add(lca);
		boolean flag = false;
		for (int i = path2.size() - 1; i >= 0; i--) {
			TreeNode cur = path2.get(i);
			if (cur == lca) {
				flag = true;
				continue;
			}
			if (flag) {
				fullPath.add(cur);
			}
		}
		return fullPath;
	}
	private List<TreeNode> findPathFromRoot(TreeNode root, TreeNode node) {
		List<TreeNode> path = new ArrayList<TreeNode>();
		findPathFromRootHelper(root, node, path);
		return path;
	}
	private boolean findPathFromRootHelper(TreeNode root, TreeNode node, List<TreeNode> path) {
		if (root == null) {
			return false;
		}
		boolean left = findPathFromRootHelper(root.left, node, path);
		boolean right = findPathFromRootHelper(root.right, node, path);
		if (root == node || left || right) {
			path.add(root);
			return true;
		}
		return false;
	}
	private TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || root == n1 || root == n2) {
			return root;
		}
		TreeNode left = LCA(root.left, n1, n2);
		TreeNode right = LCA(root.right, n1, n2);
		if (left != null && right != null) {
			return root;
		} else {
			return left == null ? right : left;
		}
	}
}