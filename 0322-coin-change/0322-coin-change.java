class Solution {
    public static int coinsNeeded(int ind, int amount ,int coins[],int[][] dp){
        if(ind==0){
            if(amount%coins[0]==0){
               return amount / coins[0];
            }else{
                return (int)1e9;
            }
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        //pick
        int pick = (int)1e9;
        if(coins[ind]<=amount)
        pick = 1 + coinsNeeded(ind,amount-coins[ind],coins,dp);
        int notPick = 0 +  coinsNeeded(ind-1,amount,coins,dp);
        return dp[ind][amount] = Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = coinsNeeded(coins.length-1,amount,coins,dp);
       return ans==(int)1e9 ? -1 : ans;
}
}