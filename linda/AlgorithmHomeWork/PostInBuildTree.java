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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
        return buildTreeRec(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);   
    }
        
    private TreeNode buildTreeRec(int[] inorder, int start, int inend, int[] postorder, int psend){
        
        if (start > inend ){
            return null;
        }
        
        //post last node is root
        TreeNode curRoot = new TreeNode(postorder[psend]);
        
        //find root in the inorder
        int rootIndex = 0;
        for (int i = inend; i >= start; i--){
            
            if (inorder[i] == postorder[psend]){
                rootIndex = i;
                break;
            }
        }
        
       curRoot.left = buildTreeRec(inorder, start, rootIndex - 1, postorder, psend - (inend- rootIndex) -1);  
       curRoot.right = buildTreeRec(inorder, rootIndex + 1, inend, postorder, psend - 1);  
    
        return curRoot;
        
    }
}