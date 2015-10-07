public class Solution {
    public int rob(int[] nums) {
        //sum[n] contains the max amount of the money at n position can be robbed
        int[] sum = new int[nums.length];
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[0] + nums[2];
        for(int i = 3; i < nums.length; i++){
            sum[i] = Math.max(sum[i-2], sum[i-3]) + nums[i];
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }
}