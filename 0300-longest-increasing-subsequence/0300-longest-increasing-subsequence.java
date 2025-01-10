class Solution {
    public int f(int i, int prev , int[] nums,int[][] dp){
        if(i==nums.length) return 0;
        int pick=0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        if(prev==-1 || nums[i]>nums[prev]){
          pick = 1+f(i+1,i,nums,dp);
        }
        int notPick = f(i+1,prev,nums,dp);
        return dp[i][prev+1] = Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int prev=i-1; prev>=-1; prev--){    
               int pick=0;
               if(prev==-1 || nums[i]>nums[prev]){
                   pick = 1 + dp[i+1][i+1];
               }
               int notPick = dp[i+1][prev+1];
               dp[i][prev+1] = Math.max(pick,notPick);
            }
        }
        return dp[0][0];
    }
}