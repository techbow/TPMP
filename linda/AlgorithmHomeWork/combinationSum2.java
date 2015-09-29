public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
           
       ArrayList<Integer> list = new ArrayList<Integer>();
       List<List<Integer>> result =new  ArrayList<List<Integer>> ();
       Arrays.sort(candidates);
       combinationSumRec(list, 0, candidates, target, result);
       return (List<List<Integer>>)result;
    } 
    
    private void combinationSumRec(ArrayList<Integer> list, int startPos, int[] candidates, int target, List<List<Integer>> result){
        
        int sum = 0;
        for (int i = 0; i <= list.size() -1 ; i++ ){
            sum = sum + list.get(i);
        }
        if (sum > target){
            return;   
        }    
        if (sum == target){
            result.add(new ArrayList<Integer>(list));
            return;
        }
         if (startPos > candidates.length -1 ){
            return;
        }
        int pre = -1;
        for (int i = startPos ; i <=candidates.length -1; i++){
            if (pre == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            combinationSumRec(list, i+1, candidates, target, result);
            list.remove(list.size() -1);
            pre = candidates[i];
        }
        return;
    }
}