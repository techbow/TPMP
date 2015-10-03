public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subComb = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
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
            if(i == start || candidates[i] != candidates[i - 1]){
                subComb.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, subComb, result);
                subComb.remove(subComb.size()-1);
            }
        }
    }
}