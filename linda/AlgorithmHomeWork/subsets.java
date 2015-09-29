public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result =new  ArrayList<List<Integer>> ();
        Arrays.sort(nums); 
        return subsetsRec(list, 0, nums,result);
    }
    
    private List<List<Integer>> subsetsRec(List<Integer> list, int iStart, int[] nums, List<List<Integer>> result){
        
        if(iStart > nums.length ){
            return null;
        }
        
        result.add(new ArrayList<Integer>(list));
        for(int i = iStart; i <= nums.length -1; i++  ){
            list.add(nums[i]);
            subsetsRec(list, i + 1 , nums, result);
            list.remove(list.size()-1);
        }
        return result;
    }
}