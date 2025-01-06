class Solution {
        public int rob1(int[] nums) {
        int dp[] = new int[nums.length];
         dp[0]=nums[0];
         for(int i=1; i<nums.length; i++){
            int take=nums[i];
            if(i>1) take+=dp[i-2];
            int notTake = dp[i-1];
            dp[i]=Math.max(take,notTake);
         }
         for(int i : dp) System.out.print(i + " ");
         return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int arr1[] = new int[nums.length-1];
        int arr2[] = new int[nums.length-1];
        for(int i=0; i<nums.length-1; i++){
            arr1[i] = nums[i];
        }
        for(int i=1; i<nums.length; i++){
            arr2[i-1] = nums[i];
        }
        return Math.max(rob1(arr1),rob1(arr2));
    }
}