class Solution {
    public static int sum(int row,int col,List<List<Integer>> triangle,int n,int[][] dp){
        if(row==n-1) return triangle.get(row).get(col);
        if(dp[row][col]!=-1) return dp[row][col];
        int down = triangle.get(row).get(col) + sum(row+1,col,triangle,n,dp);
        int left = triangle.get(row).get(col) + sum(row+1,col+1,triangle,n,dp);
        return dp[row][col]=Math.min(down,left);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return sum(0,0,triangle,n,dp);
    }
}