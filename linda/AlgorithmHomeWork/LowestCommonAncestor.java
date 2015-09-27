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
        
        LinkedList<TreeNode> ancestor = new LinkedList<TreeNode>();
        getCommonAnNode(root, p, q, ancestor);
        return ancestor.getFirst();    
        
    }

    public int getCommonAnNode(TreeNode root, TreeNode p, TreeNode q , LinkedList<TreeNode> ancestor){
        
        if (root == null){
            return 0;
        }
        
        //divide
        int left = getCommonAnNode(root.left, p, q, ancestor);
        int right = getCommonAnNode(root.right, p, q, ancestor);
        
        //conquer  
        int total = left + right;
        if (root == q || root == p) { //if the current node is one of our target
            if (total == 1){ // if already found another target, add current node.
                ancestor.add(root);
            }
            return total + 1;
            
        } 
        else 
        {
            if (total == 2 ){
                ancestor.add(root);
            }
        }
        return total;
        
    }
}