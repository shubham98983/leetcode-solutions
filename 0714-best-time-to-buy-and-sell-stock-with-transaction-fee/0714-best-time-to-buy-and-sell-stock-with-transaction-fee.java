class Solution {
    public int f(int i, int buy ,int fee , int[] prices,int[][] dp){
       if(i==prices.length) return 0;
       int profit;
       if(dp[i][buy]!=-1) return dp[i][buy];
       if(buy==0){
         profit = Math.max(-prices[i]+f(i+1,1,fee,prices,dp) , 0+f(i+1,0,fee,prices,dp));
       }else{
          profit = Math.max((prices[i] - fee )+ f(i+1,0,fee,prices,dp) , 0 + f(i+1,1,fee,prices,dp));
       }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return f(0,0,fee,prices,dp);
    }
}