class Solution {
        public static boolean subsetSum(int idx,int target,int[] arr,int[][] dp){
        if(target==0) return true;
        if(idx==0) return(target==arr[0]);
        if(dp[idx][target]!=-1) return dp[idx][target]==1 ? true : false;
        //not taken
        boolean notTake = subsetSum(idx-1,target,arr,dp);
        //take
        boolean take=false;
        if(arr[idx]<=target)
        take = subsetSum(idx-1,target-arr[idx],arr,dp);
        dp[idx][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int total=0;
       for(int i : nums){
          total+=i;
       }
       if(total%2!=0) return false;
       int target = total/2;
        int dp[][] = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return subsetSum(n-1,target,nums,dp);
    }
}