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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }

        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftList = helper(start, i-1);
            List<TreeNode> rightList = helper(i+1, end);
            for(int j = 0; j < leftList.size(); j++){
                for(int k = 0; k < rightList.size(); k++){
                    TreeNode node = new TreeNode(i);
                    node.left = leftList.get(j);
                    node.right = rightList.get(k);
                    res.add(node);
                }
            }
        }
        return res;
    }
}