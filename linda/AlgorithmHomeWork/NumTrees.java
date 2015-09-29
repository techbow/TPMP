public class Solution {
    public int numTrees(int n) {
         
        int[] trees = new int[n+1];
        trees[0] = 1;
        trees[1] = 1;
         // DP solution based upon the idea that the number of trees with "n" elements is
         // related to the number of left and right subtrees that can be constructed
         // using 0 to n-1 elements.

        for (int tree=2; tree <= n; tree++) {
            int numTrees = 0;
            for (int i=1; i <= tree; i++) {
                int numLTrees = trees[i-1];
                int numRTrees = trees[tree-i];
                numTrees += numLTrees * numRTrees;
            }   
            trees[tree] = numTrees;
        }//for

        return trees[n];
    }
}