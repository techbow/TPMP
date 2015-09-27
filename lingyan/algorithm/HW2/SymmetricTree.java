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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        
        return isSymUtil(root.left, root.right);
    }
    
    public boolean isSymUtil(TreeNode lnode, TreeNode rnode){
        if((lnode == null) && (rnode == null)){
            return true;
        }
        
        if (((lnode != null) && (rnode == null)) || ((rnode != null) && (lnode == null)) || (lnode.val != rnode.val)){
            return false;
        }
        
        return isSymUtil(lnode.left, rnode.right) && isSymUtil(lnode.right, rnode.left);
    }
}