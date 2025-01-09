class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        int profit=0;
        for(int i=n-1; i>=0; i--){
            for(int buy=1; buy>=0; buy--){   // what we take in col or our second changing parameter will be in inner loop
                if(buy==0){
                   profit = Math.max(-prices[i]+dp[i+1][1] , dp[i+1][0]);
                }else{
                    profit = Math.max((prices[i]-fee)+dp[i+1][0] , dp[i+1][1]);
                }
                dp[i][buy]=profit;
            }
        }
       return dp[0][0];
    }
}