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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.empty()){
            node = stack.pop();
            if(find(node, p, q) == 1){
                break;
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        
        return node;
        
        
    }
    private int find(TreeNode root, TreeNode p, TreeNode q){
            return ( 
            ((p.val < q.val) && (p.val <= root.val) && (q.val >= root.val)) ||
            ((p.val > q.val) && (p.val >= root.val) && (q.val <= root.val))) ? 1 : 0;
        }
}