class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr=0;
        for(int i=0; i<nums.length; i++){
            xorr=xorr^nums[i];
        }
        int right = (xorr&xorr-1)^xorr;
        int b1=0;
        int b2=0;
        for(int i=0; i<nums.length; i++){
           if((nums[i]&right)==0){
            // kisi ko bhi b1 me lelo else wali apne aap b2 main
              b1=b1^nums[i];
           }else{
               b2=b2^nums[i];
           }
        }
        int ans[] = new int[2];
        ans[0]=b1;
        ans[1]=b2;
        return ans;
    }
}