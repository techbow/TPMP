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
    public List<String> binaryTreePaths(TreeNode root) {
        
        ArrayList<String> curString = new ArrayList<String>();
        
        if (root == null){
            return curString;
        }
        
        if (root.left == null && root.right == null){
            curString.add("" + root.val);
            return curString;
        }
        
        //divide 
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        //conquer
        for (int i = 0; i < left.size(); i++){
             curString.add(root.val + "->" + left.get(i));
        }
        
        for (int i = 0; i < right.size(); i++){
                curString.add(root.val + "->" + right.get(i));
        }
        
        return curString;
        
        
    }
}