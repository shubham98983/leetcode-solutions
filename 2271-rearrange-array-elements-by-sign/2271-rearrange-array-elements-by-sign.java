class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int posindex=0;
        int negindex=1;
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i]>0){
                ans[posindex]=nums[i];
                posindex = posindex+2;
            } else{
                ans[negindex]=nums[i];
                negindex = negindex+2;
            }
        }
        return ans;
           }
        }