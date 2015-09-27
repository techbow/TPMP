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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTreeRec(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);   
    }
        
    private TreeNode buildTreeRec(int[] inorder, int instart, int inend, int[] preorder, int preFirst, int preEnd){
        
        if (instart > inend || preFirst > preorder.length ){
            return null;
        }
        
        //post last node is root
        TreeNode curRoot = new TreeNode(preorder[preFirst]);
        
        //find root in the inorder
        int rootIndex = 0;
        for (int i = 0; i <= inend; i++){
            
            if (inorder[i] == preorder[preFirst]){
                rootIndex = i;
                break;
            }
        }
       
       curRoot.left = buildTreeRec(inorder, instart, rootIndex - 1, preorder,preFirst + 1, preFirst + rootIndex - instart);  
       curRoot.right = buildTreeRec(inorder, rootIndex + 1, inend, preorder,  rootIndex - inend + preEnd + 1 ,preEnd);  
    
        return curRoot;
        
    } 
}