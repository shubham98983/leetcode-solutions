class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int len=0;
        int max=0;
        while(r<n){
            if(nums[r]==0){
                k--;
            }
            if(k<0){
                if(nums[l]==0){
                    k++;
                }
                l++;
            }
            if(k>=0){
             len=r-l+1;
                 max=Math.max(len,max);
            }
            r++;
        }
        return max;
    }
}