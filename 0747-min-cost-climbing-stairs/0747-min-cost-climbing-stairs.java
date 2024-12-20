class Solution {
    public static int min(int idx,int[] cost,int[] dp){
        if(idx==0) return cost[0];
        if(idx==1) return cost[1];
        if(dp[idx]!=-1) return dp[idx];
        int step1 = min(idx-1,cost,dp);
        if(idx<cost.length) step1+=cost[idx];
        int step2 = min(idx-2,cost,dp);
        if(idx<cost.length) step2+=cost[idx];
        return dp[idx]=Math.min(step1,step2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i]=-1;
        }
        return min(n,cost,dp);
    }
}