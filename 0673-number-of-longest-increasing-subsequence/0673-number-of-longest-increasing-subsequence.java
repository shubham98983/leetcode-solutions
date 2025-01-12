class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        int max=1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0; i<n; i++){
           for(int j=0; j<i; j++){
              if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                 dp[i] = 1+dp[j];
                 count[i]=count[j];
              }else if(nums[j]<nums[i] && 1+dp[j]==dp[i]){
                 count[i] = count[i]+count[j];
              }
           }
            max = Math.max(max,dp[i]);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            if(dp[i]==max){
               ans+=count[i];
            }
        }   
        return ans;
    }
}