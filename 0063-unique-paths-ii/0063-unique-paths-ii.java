class Solution {
    public static int path(int row,int col,int[][] arr,int[][] dp){
        if(row<0 || col<0) return 0;
        if(arr[row][col]==1) return 0;
        if(row==0 && col==0) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int up = path(row-1,col,arr,dp);
        int left = path(row,col-1,arr,dp);
        return dp[row][col] = up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
         int prev[] = new int[m];
        for(int i=0; i<n; i++){
            int dp[] = new int[m];
            for(int j=0; j<m; j++){
                 if(i==0 && j==0){
                    dp[j]=1;
                    continue;
                 }
                int up=0;
                int left=0;
                if(i>0 && obstacleGrid[i][j]==0){
                    up = prev[j];
                }
                if(j>0 && obstacleGrid[i][j]==0){
                    left = dp[j-1];
                }
                dp[j]=up+left;
            }
            prev=dp;
        }
        return prev[m-1];
    }
}