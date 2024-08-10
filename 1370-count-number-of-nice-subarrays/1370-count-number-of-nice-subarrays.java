class Solution {
     public static int subarraySum(int[] arr, int target){
        if(target<0) return 0;
        int r=0;
        int l=0;
        int sum=0;
        int count=0;
        while(r<arr.length){
            sum+=arr[r]%2;
            while(sum>target){
                sum=sum-(arr[l]%2);
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int a = subarraySum(nums,k);
        int b = subarraySum(nums,k-1);
        int result=a-b;
        return result;
    }
}