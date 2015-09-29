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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
             return null;
        }
        else if (nums.length == 1){
            return new TreeNode(nums[0]);
        }
        else{
            return buildBST(nums, 0, nums.length -1);
        }
    }
    public TreeNode buildBST(int[] nums, int start, int end){
        
        if (end - start < 1){
            return new TreeNode(nums[start]);
        }
        
        int middle = end - (end-start)/2;
        TreeNode curNode = new TreeNode( nums[middle] );
        
        TreeNode left = null;
        if (start <= middle -1){
            left = buildBST(nums, start, middle-1);
        }
        
        TreeNode right = null;
        if (middle+1 <= end){
            right = buildBST(nums, middle+1, end);
        }
        
        curNode.left = left;
        curNode.right = right;
        
        return curNode;
    }
}