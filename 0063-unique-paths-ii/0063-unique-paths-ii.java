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
        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return path(n-1,m-1,obstacleGrid,dp);
    }
}