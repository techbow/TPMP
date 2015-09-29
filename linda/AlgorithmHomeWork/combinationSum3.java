public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       int [] nums = {1,2,3,4,5,6,7,8,9};
       List<Integer> list = new ArrayList<Integer>();
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       combinationSum3Rec(list, 0, nums, k, n, result);
       return result;
    }   
    
    
    public void combinationSum3Rec(List<Integer> list, int startPos, int nums[],int k, int n, List<List<Integer>> result){
           
          if (list.size() == k){
              int sum = 0;
              for (int i = 0; i <list.size(); i++){
                  sum = sum + list.get(i);
              }
              if (sum == n){
                  result.add(new ArrayList<Integer>(list));
              }
              return;
          }
          
          //if(list.size > k){
            //   return;
          //}
           
          for (int i = startPos ; i < 9; i ++) {
              list.add(nums[i]);
              combinationSum3Rec(list, i+1, nums, k, n, result);
              list.remove(list.size()-1);
          }
          return;
    }
    
}