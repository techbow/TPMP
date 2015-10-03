public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums= {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> subComb = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0;
        int target = n;
        dfs(k, start, target, nums, subComb, result);
        return result;
    }
    
    public void dfs(int k, int start, int target, int[] nums, List<Integer> subComb, List<List<Integer>> result){
        if(target == 0 && subComb.size() == k){
            result.add(new ArrayList<Integer>(subComb));
        }
        if(target <= 0 || subComb.size() > k){
            return;
        }
        for(int i = start; i < nums.length; i++){
            subComb.add(nums[i]);
            dfs(k, i + 1, target - nums[i], nums, subComb, result);
            subComb.remove(subComb.size() - 1);
        }
    }
}