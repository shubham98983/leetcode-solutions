class Solution {
    public int maximumDifference(int[] nums) {
        int mini = nums[0];
        int maxdiff =0;
        for(int i=1; i<nums.length; i++){
           int diff = nums[i]-mini;
           maxdiff = Math.max(diff,maxdiff);
           mini = Math.min(nums[i],mini);
        }
        return maxdiff==0 ? -1:maxdiff;
    }
}