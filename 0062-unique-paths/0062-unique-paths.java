class Solution {
    public static int path(int row,int col,int[][] dp){
        if(dp[row][col]!=-1) return dp[row][col];
        if(row==0 || col==0) return 1;
        int up = path(row-1,col,dp);
        int left = path(row,col-1,dp);
        return dp[row][col] = up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return path(m-1,n-1,dp);
    }
}