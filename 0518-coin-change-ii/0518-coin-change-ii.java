class Solution {
    public static int ways(int ind,int target,int[] coins,int[][] dp){
        if(ind==0){
            if(target%coins[0]==0) return 1;
            else return 0;
        }
        int pick = 0;
        if(coins[ind]<=target)
        pick = ways(ind,target-coins[ind],coins,dp);
        int notPick = ways(ind-1,target,coins,dp);
        return dp[ind][target] = pick+notPick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i]=1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<=amount; j++){
                int take=0;
                if(coins[i]<=j) take = dp[i][j-coins[i]];
                int notTake = dp[i-1][j];
                dp[i][j]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }
}