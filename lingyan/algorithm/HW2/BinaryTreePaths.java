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
        ArrayList<String> result = new ArrayList<String>();
        if (root == null){
            return result;
        }
        String path = "";
        traverse(root, result, path);
        return result;
    }
        
        private void traverse(TreeNode root, ArrayList<String> result, String path){//traverse to root
            if((root.left == null) && (root.right == null)){
                path = path + String.valueOf(root.val);
                result.add(path);
                return;
                }

            
            String temp = path;
            path = path + String.valueOf(root.val) + "->";
            
            
            if(root.left != null){
            traverse(root.left, result, path);
            }
            
            if(root.right != null){
            traverse(root.right, result, path);
            }
            
            path = temp;
            
        }
        
}