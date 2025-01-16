class Solution {
    public int f(int i, int k,int n, int[] arr,int[] dp){
        if(i==n) return 0;
        int max = -(int)1e9;
        int maxAns = -(int)1e9;
        int len=0;
        if(dp[i]!=-1) return dp[i];
        for(int j=i; j<Math.min(i+k,n); j++){
            len++;
            max = Math.max(max,arr[j]);
            int cost = len*max + f(j+1,k,n,arr,dp);
            maxAns = Math.max(cost,maxAns);
        }
        return dp[i] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return f(0,k,arr.length,arr,dp);
    }
}