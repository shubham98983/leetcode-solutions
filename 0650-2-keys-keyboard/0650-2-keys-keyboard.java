class Solution {
    public int f(int i,int j,int n,int[][] dp){
        if(i==n) return 0;
        if(i>n) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int copyPaste = 2+f(2*i,i,n,dp);
        int paste = 1+f(i+j,j,n,dp);
        return dp[i][j] = Math.min(copyPaste,paste);
    }
    public int minSteps(int n) {
        if(n==1) return 0;
        int dp[][] = new int[n][n/2+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return 1 + f(1,1,n,dp);
    }
}