class Solution {
    public int singleNumber(int[] nums) {
        int one =0; 
        int two =0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            one=(one^nums[i])&~two;
            two=(two^nums[i])&~one;
        }
        return one;
    }
}