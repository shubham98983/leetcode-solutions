class Solution {
    public int f(int i, int j , int rob , int[][] coins,Integer[][][] dp){
        if(i==0 && j==0){
            if(coins[i][j]<0 && rob>0) return 0;
            return coins[i][j];
        }
        if(i<0 || j<0 || i>=coins.length || j>= coins[0].length){
            return -(int)1e9;
        }
        if(dp[i][j][rob]!=null) return dp[i][j][rob];
         int down = coins[i][j] +f(i-1,j,rob,coins,dp);
        if(rob>0 && coins[i][j]<0){
            down = Math.max(down,f(i-1,j,rob-1,coins,dp));
        }
         int right = coins[i][j] + f(i,j-1,rob,coins,dp);
        if(coins[i][j]<0 && rob>0){
        right = Math.max(right,0+f(i,j-1,rob-1,coins,dp));
        }
        return dp[i][j][rob] = Math.max(down,right);
    }
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        Integer dp[][][] = new Integer[n][m][3];
        return f(n-1,m-1,2,coins,dp);
    }
}