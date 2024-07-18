class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
    //finding first dip starting from last
        int idx=-1;
    for(int i=n-2; i>=0; i--){
        if(nums[i]<nums[i+1]){
           idx=i;
            break;
        }
    }
    //means no dip largest given so reverse and return smallest
    int last = n-1;
    int first=0;
    if(idx==-1){
        while(last>first){
            int temp=nums[first];
            nums[first]=nums[last];
            nums[last]=temp;
            first++;
            last--;
        }
    } else{
    for(int i=n-1; i>idx; i--){
       if(nums[i]>nums[idx]){
         int temp = nums[idx];
         nums[idx]=nums[i];
         nums[i]=temp;
         break;
       }
    }
     last=n-1;
     first=idx+1;
     while(last>first){
        int temp = nums[first];
        nums[first]=nums[last];
        nums[last]=temp;
        first++;
        last--;
     }
    }
    }
}