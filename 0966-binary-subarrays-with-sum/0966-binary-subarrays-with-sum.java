class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int count=0;
        for(int i=0; i<n; i++){
            int sum=0;
        for(int j=i; j<n; j++){
            sum=sum+nums[j];
            if(sum==goal){
                count++;
            }
            if(sum>goal){
                break;
            }
        }
        }
        return count;
    }
}