class Solution {
    public static int path(int row,int col,int[][] dp){
        if(dp[row][col]!=-1) return dp[row][col];
        if(row==0 || col==0) return 1; //this is working due to constraint of moving in down and right direction otherwise for reaching a (0,2) we have multiple path here only 1.
        int up = path(row-1,col,dp);
        int left = path(row,col-1,dp);
        return dp[row][col] = up+left;
    }
    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // dp[0][0]=1;
        int prev[] = new int[n];
        for(int i=0; i<m; i++){
            int temp[] = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    temp[j]=1;
                }else{
                    temp[j]=prev[j]+temp[j-1];
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}