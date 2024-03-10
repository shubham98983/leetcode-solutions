class Solution {
    public int majorityElement(int[] nums) {
       int el =0;
       int count =0;
    int n = nums.length;
      for(int i=0; i<n; i++){
          if(count==0){
              el=nums[i];
              count++;
          }
          else if(el==nums[i]){
              count++;
          } else{
              count--;
          }
      } 
        return el;
    }
}