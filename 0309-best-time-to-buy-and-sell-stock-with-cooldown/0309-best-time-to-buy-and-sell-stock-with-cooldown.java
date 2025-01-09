class Solution {
        public int f(int i, int buy ,int[] prices,int[][] dp){
       if(i>=prices.length) return 0;
       int profit;
       if(dp[i][buy]!=-1) return dp[i][buy];
       if(buy==0){
         profit = Math.max(-prices[i]+f(i+1,1,prices,dp) , 0+f(i+1,0,prices,dp));
       }else{
          profit = Math.max(prices[i] + f(i+2,0,prices,dp) , 0 + f(i+1,1,prices,dp));
       }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return f(0,0,prices,dp);    
    }
}