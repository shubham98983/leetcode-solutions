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
        for(int i=0; i<=n; i++){
            dp[1][i]=1;
        }
        for(int i=2; i<n; i++){
            for(int j=0; j<=n; j++){
                int pick=0;
                if(i<=j) pick = i*dp[i][j-i];
                int notPick = dp[i-1][j];
                dp[i][j] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][n];
    }
}