class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                for(int cap=1; cap<=k; cap++){
                    int profit;
                    if(j==0){
                        profit = Math.max(-prices[i]+dp[i+1][1][cap] , dp[i+1][0][cap]);
                    }else{
                        profit = Math.max(prices[i]+dp[i+1][0][cap-1] , dp[i+1][1][cap]);
                    }
                    dp[i][j][cap] = profit;
                }
            }
        }
        return dp[0][0][k];
    }
}