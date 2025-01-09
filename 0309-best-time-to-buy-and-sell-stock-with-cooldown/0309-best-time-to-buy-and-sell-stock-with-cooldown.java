class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int front2[] = new int[2];
        int front1[] = new int[2];
        int curr[] = new int[2];
        //base case already initialised with 0
        int profit=0;
        for(int i=n-1; i>=0; i--){
            for(int buy=1; buy>=0; buy--){   // what we take in col or our second changing parameter will be in inner loop
                if(buy==0){
                   profit = Math.max(-prices[i]+front1[1] , front1[0]);
                }else{
                    profit = Math.max(prices[i]+front2[0] , front1[1]);
                }
                curr[buy]=profit;
             System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(curr, 0, front1, 0, 2);
            }
        }
       return curr[0];
    }
}