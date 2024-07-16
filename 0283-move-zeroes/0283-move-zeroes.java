class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count=0;
        int idx=0;
        for(int i=0; i<n; i++){
          if(nums[i]!=0){
            nums[idx]=nums[i];
            idx++;
          } else if(nums[i]==0){
            count++;
          }
        }
        for(int i=0; i<count; i++){
            nums[n-count+i]=0;
        }
    }
}