public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(n == 3){
            return nums[0] > nums[2] ? Math.max(nums[0], nums[1]) : Math.max(nums[1], nums[2]);
        }
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[0] + nums[2];
        for(int i = 3; i < n - 1; i++){
            sum[i] = Math.max(sum[i-2], sum[i-3]) + nums[i];
        }
        int maxWNum0 = Math.max(sum[n-3], sum[n-2]);
        sum[2] = nums[2];
        sum[3] = nums[1] + nums[3];
        for(int j = 4; j < n; j++){
            sum[j] = Math.max(sum[j-2], sum[j-3]) + nums[j];
        }
        int maxWNumN = Math.max(sum[n-1], sum[n-2]);
        return Math.max(maxWNum0, maxWNumN);
    }
}