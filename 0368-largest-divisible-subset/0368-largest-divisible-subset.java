class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        Arrays.fill(hash,1);
        int maxi=1;
        int lastIdx=0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
              hash[i]=i;
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i] = j;
                }
            }
          if(dp[i]>maxi){
             lastIdx=i;
             maxi=dp[i];
          }
        }
        ans.add(nums[lastIdx]);
        while(hash[lastIdx]!=lastIdx){
            lastIdx=hash[lastIdx];
            ans.add(nums[lastIdx]);
        }
        Collections.reverse(ans);
        return ans;
    }
}