class Solution {
    public static int minSum(int row, int col, int[][] matrix,int[][] dp){
       if(col<0 || col>=matrix[0].length) return (int)1e9;
       if(row==0) return matrix[0][col];
       if(dp[row][col]!=-1) return dp[row][col];
       int up = matrix[row][col] + minSum(row-1,col,matrix,dp);
       int left = matrix[row][col] + minSum(row-1,col-1,matrix,dp);
       int right = matrix[row][col] + minSum(row-1,col+1,matrix,dp);
       return dp[row][col] = Math.min(up , Math.min(left,right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                    continue;
                }
                int left =matrix[i][j] , right = matrix[i][j];
            int down = matrix[i][j]+dp[i-1][j];
            if(j>0){
                left = left + dp[i-1][j-1];
            }else{
                left=left+(int)1e9;
            }
            if(j<n-1){
                right = right +  dp[i-1][j+1];
            }else{
                right = right + (int)1e9;
            }
            dp[i][j] = Math.min(down , Math.min(left,right));
            }
         }
         int mini = Integer.MAX_VALUE;
         for(int i=0; i<n; i++){
           mini=Math.min(mini,dp[m-1][i]);
         }
         return mini;
    }
}