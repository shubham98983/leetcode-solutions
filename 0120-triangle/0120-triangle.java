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
        int prev[] = new int[n];
        for(int j=0; j<n; j++){
            prev[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            int curr[] = new int[n];
            for(int j=i; j>=0; j--){
                int d=triangle.get(i).get(j)+prev[j];
                int dg=triangle.get(i).get(j)+prev[j+1];
                curr[j]=Math.min(d,dg);
            }
            prev=curr;
        }
        return prev[0];
    }
}