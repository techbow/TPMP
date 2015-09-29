/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        Stack<Integer> prev = new Stack<>();
        return inorder(root, prev);
    }

    private boolean inorder(TreeNode node, Stack<Integer> prev) {
        if (node == null) return true;
        if (!inorder(node.left, prev)) return false;
        if (!prev.isEmpty() && prev.pop() >= node.val) return false;
        prev.push(node.val);
        return inorder(node.right, prev);
    }
}