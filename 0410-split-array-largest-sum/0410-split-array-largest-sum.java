class Solution {
    public static boolean possible(int[] nums, int mid, int k){
        int n=nums.length;
        int count=1;
        int sum=0;
        for(int i=0; i<n; i++){
            if(sum+nums[i]<=mid){
                sum=sum+nums[i];
            }else{
                count++;
                sum=nums[i];
            }
        }
        if(count>k){
            return true;
        }
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int total=0;
        for(int i=0; i<n; i++){
          if(nums[i]>max){
            max=nums[i];
          }
          total=total+nums[i];
        }
        int low=max;
        int high=total;
        while(low<=high){
            int mid=(low+high)/2;
         if(possible(nums,mid,k)==true){
            low=mid+1;
         }else{
            high=mid-1;
         }
        }
        return low;
    }
}