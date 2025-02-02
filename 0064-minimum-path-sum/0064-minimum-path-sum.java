class Solution {
    public static int sum(int row,int col,int[][] arr,int[][] dp){
        if(row==0 && col==0) return arr[0][0];
        if(row<0 || col<0) return (int)1e9;
        if(dp[row][col] !=-1) return dp[row][col];
        int up = arr[row][col] + sum(row-1,col,arr,dp);
        int left = arr[row][col] + sum(row,col-1,arr,dp);
        return dp[row][col]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int prev[] = new int[n];
        for(int i=0; i<m; i++){
            int dp[] = new int[n];
            for(int j=0; j<n; j++){
              if(i==0 && j==0) {
                   dp[j]=grid[0][0];
                   continue;
              }
              int left=(int)1e9;
              int up= (int)1e9;
              if(i>0) up = grid[i][j]+prev[j];
              if(j>0) left = grid[i][j]+dp[j-1];
              dp[j]=Math.min(up,left);
            }
            prev=dp;
        }
        return prev[n-1];
    }
}