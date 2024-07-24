class Solution {
    public static int maximum(int[] nums){
        int n=nums.length;
        int max= Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }
    public static boolean possible(int[]nums, int mid,int threshold){
        int n =nums.length;
        int total =0;
        for(int i=0; i<n; i++){
            int q=nums[i]/mid;
            if(nums[i]%mid!=0){
                q++;
            }
            total=total+q;
        }
        if(total<=threshold){
            return true;
        }
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low=1;
        int high=maximum(nums);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
        if(possible(nums,mid,threshold)==true){
           ans=mid;
           high=mid-1;
        }else{
            low=mid+1;
        }
        }
        return ans;
    }
}