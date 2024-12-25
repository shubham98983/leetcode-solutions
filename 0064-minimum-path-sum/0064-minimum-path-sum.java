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
        int dp[][] = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return sum(m-1,n-1,grid,dp);
    }
}