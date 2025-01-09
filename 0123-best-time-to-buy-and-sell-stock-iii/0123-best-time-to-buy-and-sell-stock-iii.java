class Solution {
    public int f(int i, int buy, int cap, int[] prices,int[][][] dp){
        if(cap==0) return 0;
        if(i==prices.length) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit;
        if(buy==0){
            profit = Math.max(-prices[i]+f(i+1,1,cap,prices,dp), f(i+1,0,cap,prices,dp));
        }else{
            profit = Math.max(prices[i]+f(i+1,0,cap-1,prices,dp), f(i+1,1,cap,prices,dp));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                for(int k=1; k<3; k++){
                    int profit;
                    if(j==0){
                        profit = Math.max(-prices[i]+dp[i+1][1][k] , dp[i+1][0][k]);
                    }else{
                        profit = Math.max(prices[i]+dp[i+1][0][k-1] , dp[i+1][1][k]);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }
        return dp[0][0][2];
    }
}