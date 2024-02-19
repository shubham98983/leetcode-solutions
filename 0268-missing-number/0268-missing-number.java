class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;
    for(int i=0; i<=n; i++){
        int flag =0;
    for(int j=0; j<n; j++){
        if(nums[j]==i){
            flag=1;
            break;
        }
    }
     if(flag==0){
         missing = i;
     }
    }
        return missing;
    }
}