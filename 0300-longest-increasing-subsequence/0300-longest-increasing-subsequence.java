class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int length=1;
        int maxLength=0;
        for(int i=0; i<n-1; i++){
            int num = nums[i];
            for(int j=i+1; j<n; j++){
                if(nums[j]>num){
                    length++;
                    num=nums[j];
                    maxLength=Math.max(length,maxLength);
                }
            }
            length=1;
        }
        return maxLength;
    }
}


//this type of solution fail on subsequence here we can't explore all subsequence by skipping largest in middle if here comes a large number in middlle it will pick and will make it part of subsequnence like in [0,1,0,3,2,3] correct susbsequnce[0,1,2,3] acc to our code [0,1,3] it will pick first 3 and 2 will not be considered as part of subsequence.