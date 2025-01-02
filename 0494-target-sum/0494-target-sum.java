class Solution {
    public static int ways(int[] arr,int target){
        int n = arr.length;
        int dp[][] = new int[n][target+1];
        if(arr[0]==0) dp[0][0]=2; //these are for[0][0]
        else dp[0][0]=1;
        
        if(arr[0]!=0 && arr[0]<=target) dp[0][arr[0]] = 1;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<=target; j++){
                int notTake = dp[i-1][j];
                int take=0;
                if(arr[i]<=j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j]=take+notTake;
            }
        }
        return dp[n-1][target];
    }
    public int findTargetSumWays(int[] arr, int target) {
               int total=0;
        for(int i=0; i<arr.length; i++){
            total+=arr[i];
        }
        if(total-target<0 || (total-target)%2==1 ) return 0;
        return ways(arr,(total-target)/2);
    }
}