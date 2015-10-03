public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target < 0){
            return null;
        }
        Arrays.sort(candidates);
        List<Integer> subComb = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0;
        dfs(candidates, target, start, subComb, result);
        return result;
    }
    
    public void dfs(int[] candidates, int target, int start, List<Integer>subComb, List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList<Integer>(subComb));
        }
        if(target < 0){
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            subComb.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, subComb, result);
            subComb.remove(subComb.size() - 1);
            
        }
    }
}