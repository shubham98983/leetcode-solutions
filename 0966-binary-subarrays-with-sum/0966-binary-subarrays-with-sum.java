class Solution {
    public static int subarraySum(int[] arr, int target){
        if(target<0) return 0;
        int r=0;
        int l=0;
        int sum=0;
        int count=0;
        while(r<arr.length){
            sum+=arr[r];
            while(sum>target){
                sum=sum-arr[l];
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = subarraySum(nums,goal);
        int b = subarraySum(nums,goal-1);
        int result=a-b;
        return result;
    }
}