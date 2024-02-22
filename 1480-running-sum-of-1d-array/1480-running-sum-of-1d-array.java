class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int sum[] = new int[n];
        for(int i=0; i<n; i++){
            int rsum =0;
        for(int j=0; j<=i; j++){
            rsum = rsum+nums[j];
        }
            sum[i]=rsum;
        }
        return sum;
    }
}