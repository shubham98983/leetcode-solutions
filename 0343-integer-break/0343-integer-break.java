class Solution {
    public static int maxProduct(int ind,int n,int dp[][]){
        if(ind==1){
             return 1;
        }
        if(dp[ind][n]!=-1) return dp[ind][n];
        int pick =0;
        if(ind<=n) pick = ind* maxProduct(ind,n-ind,dp);
        int notPick = maxProduct(ind-1,n,dp);
        return dp[ind][n] = Math.max(pick,notPick);
    }
    public int integerBreak(int n) {
        int dp[][] = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return maxProduct(n-1,n,dp);
    }
}