class Solution {
    public static int minSum(int row,int last,int[][] grid,int[][] dp){
        if(row<0) return 0;
        if(dp[row][last]!=-1) return dp[row][last];
        if(row==0){
           int mini = Integer.MAX_VALUE;
           for(int i=0; i<grid.length; i++){
             if(i!=last){
                mini = Math.min(mini,grid[0][i]);
             }
           }
           return dp[row][last] = mini;
        }
         int mini = Integer.MAX_VALUE;
        for(int i=0; i<grid.length; i++){
            if(i!=last){
                int sum = grid[row][i]+minSum(row-1,i,grid,dp);
                mini = Math.min(mini,sum);
            }
        }
        return dp[row][last] = mini;
    }
    public int minFallingPathSum(int[][] grid) {
        int mini = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid.length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        for(int i=0; i<grid.length; i++){
           int sum = grid[grid.length-1][i]+minSum(grid.length-2,i,grid,dp);
           dp[grid.length-1][i] = sum;
        }
        for(int i=0; i<grid.length; i++){
            mini = Math.min(mini,dp[grid.length-1][i]);
        }
        return mini;
    }
}