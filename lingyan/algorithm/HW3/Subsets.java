public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        List<List<Integer>> powerset = new ArrayList<List<Integer>>();
        if (nums == null){
            return null;
        }
        Arrays.sort(nums);
        int start = 0;
        dfs(nums, start, subset, powerset);
        return powerset;
    }
    
    public void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> powerset){
        powerset.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, powerset);
            subset.remove(subset.size()-1); //last element index, if remove(num[i]) when nums[1]=2, subset = [1,2] it will return out of range error, subset.size() = 2, max value of index is 1, nums[2] is not accessible
        }
    }
}