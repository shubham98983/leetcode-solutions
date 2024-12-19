class Solution {
    public static int climb(int n,int[] dp){
       if(n<=1) return 1;
       if(dp[n]!=-1) return dp[n];
       return dp[n]=climb(n-1,dp)+climb(n-2,dp);
    }
    public int climbStairs(int n) {
        int arr[] = new int[n+1];
        for(int i=0; i<n+1; i++){
            arr[i]=-1;
        }
        return climb(n,arr);
    }
}